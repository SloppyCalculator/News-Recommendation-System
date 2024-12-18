package com.example.newsrecommendationsystem;

import com.example.newsrecommendationsystem.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.sql.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdmInMainController {
    private static final String DB_URL = "jdbc:sqlite:user-article.db";
    private static final String TABLE_NAME = "articles";
    private UserRepository userRepository;
    private ArticleRepository articleRepository = new ArticleRepository(new DatabaseManager());
    private DatabaseManager databaseManager;
    @FXML
    private Button loadButton;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorMessage;
    private Admin admin;
    public void onManageUsers(){
        userRepository = new UserRepository(databaseManager);
        List <User> users = userRepository.loadAllUsers();

        // Create a new Stage (window) for displaying the articles
        Stage stage = new Stage();
        stage.setTitle("Users");

        // Create a TableView to display the users
        TableView<User> tableView = new TableView<>();

        // Define the column for the TableView to display the username
        TableColumn<User, String> titleColumn = new TableColumn<>("Username");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        // Create a "Read Article" button column
        TableColumn<User, Void> actionColumn = new TableColumn<>("Delete");
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("Delete User");

            {
                deleteButton.setOnAction(e -> {
                    User user = getTableView().getItems().get(getIndex());

                    if (user != null) {
                        // Handle the "Read Article" action
                        deleteUser(user);
                        stage.close();
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        // Add columns to the TableView
        tableView.getColumns().addAll(titleColumn, actionColumn);

        // Populate the TableView with articles
        ObservableList<User> usersObservableList = FXCollections.observableArrayList(users);
        tableView.setItems(usersObservableList);

        // Set up the layout and scene for the new window
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 600, 400); // Adjust the size as needed
        stage.setScene(scene);

        // Show the new window
        stage.show();

    }

    // Deletes selected user form the database
    public void deleteUser(User user) {
        boolean confirmed = confirmAndDeleteUser(user);
        if (confirmed) {
            userRepository = new UserRepository(databaseManager);
            if (userRepository.deleteUserById(user.getUserID())) {
                showSuccessAlert("Success", "User "+user.getUsername() + " has been " +
                        "deleted successfully");
            }
            onManageUsers(); // Refresh the list after deletion
        }
    }

    // Gets confirmation for deletion
    private boolean confirmAndDeleteUser(User user) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Delete User");
        confirmationAlert.setHeaderText("Are you sure you want to delete this user?");
        confirmationAlert.setContentText("User: " + user.getUsername());

        ButtonType deleteButton = new ButtonType("Delete");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirmationAlert.getButtonTypes().setAll(deleteButton, cancelButton);

        // Show the alert and wait for the user's response
        return confirmationAlert.showAndWait().filter(response -> response == deleteButton).isPresent();
    }

    public void onManageArticles(){
        articleRepository = new ArticleRepository(databaseManager);
        List <Article> articles = articleRepository.getAllArticles();

        // Create a new Stage (window) for displaying the articles
        Stage stage = new Stage();
        stage.setTitle("Articles");

        // Create a TableView to display the users
        TableView<Article> tableView = new TableView<>();

        // Define the column for the TableView to display the username
        TableColumn<Article, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Create a "Read Article" button column
        TableColumn<Article, Void> actionColumn = new TableColumn<>("Delete");
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("Delete Article");

            {
                deleteButton.setOnAction(e -> {
                    Article article = getTableView().getItems().get(getIndex());
                    if (article != null) {
                        // Handle the "Read Article" action
                        deleteArticle(article);
                        stage.close();
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        // Add columns to the TableView
        tableView.getColumns().addAll(titleColumn, actionColumn);

        // Populate the TableView with articles
        ObservableList<Article> articlesObservableList = FXCollections.observableArrayList(articles);
        tableView.setItems(articlesObservableList);

        // Set up the layout and scene for the new window
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 600, 400); // Adjust the size as needed
        stage.setScene(scene);

        // Show the new window
        stage.show();

    }

    public void deleteArticle(Article article) {
        boolean confirmed = confirmAndDeleteArticle(article);
        if (confirmed) {
            articleRepository = new ArticleRepository(databaseManager);
            if (articleRepository.deleteArticle(article.getId())) {
                showSuccessAlert("Success", "Article" + article.getTitle() +
                        "deleted successfully");
            }
            onManageArticles(); // Refresh the list after deletion
        }
    }

    private boolean confirmAndDeleteArticle(Article article) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Delete Article");
        confirmationAlert.setHeaderText("Are you sure you want to delete this article?");
        confirmationAlert.setContentText("Title: " + article.getTitle());

        ButtonType deleteButton = new ButtonType("Delete");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirmationAlert.getButtonTypes().setAll(deleteButton, cancelButton);

        // Show the alert and wait for the user's response
        return confirmationAlert.showAndWait().filter(response -> response == deleteButton).isPresent();
    }



    public void onLoginButtonClick(ActionEvent event) throws IOException {
        admin = new Admin();
        if(admin.verifyPassword(passwordField.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-main.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        }else{
            errorMessage.setText("Incorrect password. Try again");
        }
    }

    public void onCancel(ActionEvent event){
        passwordField.clear();
    }

    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void onLogOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void onLoadArticles() {

        // Hide main stage
        Stage mainStage = (Stage) loadButton.getScene().getWindow();
        mainStage.hide();

        // Show processing stage
        Stage processingStage = new Stage();
        processingStage.setTitle("Processing...");
        Button processingButton = new Button("Processing...");
        VBox vbox = new VBox(processingButton);
        Scene processingScene = new Scene(vbox, 200, 100);
        processingStage.setScene(processingScene);
        processingStage.show();

        // Open file chooser to select CSV file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);

        if (selectedFile != null) {
            // Start background task for processing
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    List<String[]> data = readLast50Rows(selectedFile.getAbsolutePath());
                    loadToSQLiteWithConcurrency(data);
                    return null;
                }
            };

            // On task success, show success message and return to main stage
            task.setOnSucceeded(event -> {
                showSuccessAlert("Data Loaded", "The data was successfully loaded into the database.");
                Platform.runLater(() -> {
                    processingStage.close();
                    mainStage.show();
                });
            });

            // On task failure, show error message
            task.setOnFailed(event -> {
                showErrorAlert("Error Occurred", "Failed to load the data.", task.getException().getMessage());
                Platform.runLater(() -> {
                    processingStage.close();
                    mainStage.show();
                });
            });

            // Execute task
            new Thread(task).start();
        } else {
            // Handle if no file selected
            showErrorAlert("No File Selected", "File Selection Error", "You didn't select any file. Please select a valid CSV file.");
            processingStage.close();
            mainStage.show();
        }
    }

    // Checks validity of each record
    private boolean isValidRow(String[] row) {
        return row.length >= 5 &&
                row[2] != null && !row[2].isEmpty() && // Validate `guid`
                row[3] != null && row[3].startsWith("http") && // Validate URL format
                row[0] != null && !row[0].isEmpty(); // Validate `title`
    }

    // Only takes in last 50 records to save computing time and also to manage api calls
    private List<String[]> readLast50Rows(String filePath) throws IOException {
        List<String[]> allRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            boolean isHeader = true;
            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                if (!isValidRow(row)) {
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


    // Receives records and converts them to be added in the database
    private void loadToSQLiteWithConcurrency(List<String[]> data) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                createTableIfNotExists(conn);

                ExecutorService executorService = Executors.newFixedThreadPool(4);
                String insertSQL = "INSERT INTO " + TABLE_NAME + " (title, pubDate, guid, link, description, category) VALUES (?, ?, ?, ?, ?, ?)";

                for (String[] row : data) {
                    executorService.submit(() -> {
                        try {
                            if (row.length < 5) {
                                Platform.runLater(() ->
                                        System.out.println("Invalid row format, skipping: " + String.join(",", row))
                                );
                                return;
                            }
                            // Checks duplicity by checking guids
                            String guid = row[2]; // 'guid' is an unique column
                            if (!isDuplicate(conn, guid)) { // checks if similar article is present
                                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                                    String description = row[4];
                                    String category = ZeroShotClassification.categorizeDescription(description);
                                    String formattedDate = convertToSQLiteFormat(row[1]);

                                    pstmt.setString(1, row[0]);
                                    pstmt.setString(2, formattedDate);
                                    pstmt.setString(3, guid);
                                    pstmt.setString(4, row[3]);
                                    pstmt.setString(5, description);
                                    pstmt.setString(6, category);
                                    pstmt.executeUpdate();

                                    // Update UI if needed
                                    Platform.runLater(() ->
                                            System.out.println("Inserted row successfully: " + String.join(",", row))
                                    );
                                }
                            } else {
                                Platform.runLater(() ->
                                        System.out.println("Duplicate found, skipping row: " + String.join(",", row))
                                );
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                            Platform.runLater(() ->
                                    System.err.println("Error inserting row: " + e.getMessage())
                            );
                        }
                    });
                }

                executorService.shutdown();
                executorService.awaitTermination(1, TimeUnit.MINUTES); // Adjust timeout as needed
                Platform.runLater(() ->
                        showSuccessAlert("Success", "Data has been successfully loaded")
                );
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    private void createTableIfNotExists(Connection conn) throws SQLException {
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

    // The data which day, date and time is converted to date and time
   private String convertToSQLiteFormat(String dateStr) {
        dateStr = dateStr.replace(",", "");
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss z");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            java.util.Date date = inputFormat.parse(dateStr);
            return outputFormat.format(date);
        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Date Conversion Error");
            alert.setHeaderText("Invalid Date Format");
            alert.setContentText("An error occurred while parsing the date: " + dateStr);
            alert.showAndWait();
            throw new RuntimeException("Error parsing date: " + dateStr, e);
        }
    }

    // shows an error
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


    // Used for preventing duplicate articles
    private boolean isDuplicate(Connection conn, String guid) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE guid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, guid); // Set the GUID parameter
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.getInt(1) > 0; // Returns true if count > 0, indicating a duplicate
            }
        }
    }





}


