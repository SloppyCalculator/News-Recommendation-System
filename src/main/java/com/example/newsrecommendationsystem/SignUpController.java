package com.example.newsrecommendationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.google.gson.Gson;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;


public class SignUpController {
    @FXML
    protected TextField usernameField;
    @FXML
    protected TextField passwordField;
    @FXML
    protected TextField confirmPasswordField;
    @FXML
    protected CheckBox politicsSelect;
    @FXML
    protected CheckBox sportsSelect;
    @FXML
    protected CheckBox entertainmentSelect;
    @FXML
    protected CheckBox educationSelect;
    @FXML
    protected CheckBox lifestyleSelect;
    @FXML
    protected CheckBox healthSelect;
    @FXML
    protected CheckBox businessSelect;
    @FXML
    protected CheckBox technologySelect;
    @FXML
    protected Label errorMessage;
    private ArrayList <String> preferences = new ArrayList<>();
    private User user;
    private UserRepository userRepository = new UserRepository(new DatabaseManager());

    public void storeUserCredentials(String username, String password) {
        try {
            // Write to a file
            File file = new File("user_credentials.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false)); // true to append
            writer.write("Username: " + username + ", Password: " + password);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User extractUserFromFile() throws IOException {
        File file = new File("user_credentials.txt");
        String username = null;
        String password = null;

        // Read the file and extract the username and password
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
                // Check if the line contains both username and password
                if (line.startsWith("Username: ") && line.contains("Password: ")) {
                    // Split the line into username and password based on the format
                    String[] parts = line.split(", ");
                    if (parts.length == 2) {
                        // Extract username and password
                        username = parts[0].substring("Username: ".length()).trim();
                        password = parts[1].substring("Password: ".length()).trim();
                    }
                }
            }
        }

        if (username != null && password != null) {
            // Create a new User object
            User user = new User(username, password, "no-hash");
            // Delete the file after extracting the credentials
            Files.delete(Paths.get(file.toURI()));

            return user;
        } else {
            throw new IOException("Failed to extract username and password from the file.");
        }
    }


    public void onLoginButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void onSignUpButtonClick(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            errorMessage.setText("Please fill in all fields.");
        }else {
            if (!userRepository.doesUsernameExist(username)) {
                if (!password.equals(confirmPassword)) {
                    errorMessage.setText("Passwords do not match.");
                }else{
                    user = new User(username, password);
                    storeUserCredentials(user.getUsername(), user.getPassword());
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("preference-select-view.fxml"));
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                    stage.show();


                }
            } else {
                errorMessage.setText("Username already exists.");
            }
        }



    }

    public void onSubmitButton(ActionEvent event) throws IOException {
        // Extract user credentials from the file
        User user = extractUserFromFile();

        if(politicsSelect.isSelected()){
           user.getPreferences().add("Politics");
        }
        if(sportsSelect.isSelected()){
            user.getPreferences().add("Sports");
        }
        if(entertainmentSelect.isSelected()){
            user.getPreferences().add("Entertainment");
        }
        if(educationSelect.isSelected()){
            user.getPreferences().add("Education");
        }
        if(lifestyleSelect.isSelected()){
            user.getPreferences().add("Lifestyle");
        }
        if(healthSelect.isSelected()){
            user.getPreferences().add("Health");
        }
        if(businessSelect.isSelected()){
            user.getPreferences().add("Business");
        }
        if(technologySelect.isSelected()){
            user.getPreferences().add("Technology");
        }
        userRepository.createUser(user.getUsername(), user.getPassword(), user.getPreferences());
        UserSession session = UserSession.getInstance();
        session.setUsername(user.getUsername());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("preferred-articles.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }

    public void onSkipButton(ActionEvent event) throws IOException {
        User user = extractUserFromFile();
        userRepository.createUser(user.getUsername(), user.getPassword(), user.getPreferences());
        UserSession session = UserSession.getInstance();
        session.setUsername(user.getUsername());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("preferred-articles.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }




}
