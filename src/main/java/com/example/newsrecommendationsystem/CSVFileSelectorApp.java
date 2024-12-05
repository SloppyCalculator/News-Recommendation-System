package com.example.newsrecommendationsystem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CSVFileSelectorApp extends Application {
    private static final String DB_URL = "jdbc:sqlite:articles.db";
    private static final String TABLE_NAME = "articles";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            Task<Void> task = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    List<String[]> data = readLast50Rows(selectedFile.getAbsolutePath());
                    loadToSQLiteWithConcurrency(data);
                    return null;
                }
            };

            task.setOnSucceeded(event -> showSuccessAlert("Data Loaded", "The data was successfully loaded into the database."));
            task.setOnFailed(event -> showErrorAlert("Error Occurred", "Failed to load the data.", task.getException().getMessage()));

            new Thread(task).start();
        } else {
            showErrorAlert("No File Selected", "File Selection Error", "You didn't select any file. Please select a valid CSV file.");
        }
    }




    private static List<String[]> readLast50Rows(String filePath) throws IOException {
        List<String[]> allRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            boolean isHeader = true;
            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                if (row.length < 5) {
                    System.out.println("Skipping invalid row: " + String.join(",", row));
                    continue;
                }
                allRows.add(row);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        int totalRows = allRows.size();
        return allRows.subList(Math.max(0, totalRows - 50), totalRows);
    }

    private static void loadToSQLiteWithConcurrency(List<String[]> data) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                createTableIfNotExists(conn);

                ExecutorService executorService = Executors.newFixedThreadPool(4); // Adjust the thread pool size
                String insertSQL = "INSERT INTO " + TABLE_NAME + " (title, pubDate, guid, link, description, category) VALUES (?, ?, ?, ?, ?, ?)";

                for (String[] row : data) {
                    executorService.submit(() -> {
                        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                            if (row.length < 5) {
                                throw new RuntimeException("Invalid row format: " + String.join(",", row));
                            }
                            String description = row[4];
                            String category = ZeroShotClassification.categorizeDescription(description);
                            String formattedDate = convertToSQLiteFormat(row[1]);

                            pstmt.setString(1, row[0]);
                            pstmt.setString(2, formattedDate);
                            pstmt.setString(3, row[2]);
                            pstmt.setString(4, row[3]);
                            pstmt.setString(5, description);
                            pstmt.setString(6, category);
                            pstmt.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                }

                executorService.shutdown();
                executorService.awaitTermination(1, TimeUnit.MINUTES); // Adjust timeout as needed
                System.out.println("Data has been successfully loaded into the SQLite database.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private static void createTableIfNotExists(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT NOT NULL, "
                + "pubDate DATE NOT NULL, "
                + "guid TEXT NOT NULL, "
                + "link TEXT NOT NULL, "
                + "description TEXT NOT NULL, "
                + "category TEXT"
                + ")";
        try (PreparedStatement pstmt = conn.prepareStatement(createTableSQL)) {
            pstmt.execute();
        }
    }

    private static String convertToSQLiteFormat(String dateStr) {
        dateStr = dateStr.replace(",", "");
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss z");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = inputFormat.parse(dateStr);
            return outputFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + dateStr, e);
        }
    }

    private void showErrorAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showSuccessAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
