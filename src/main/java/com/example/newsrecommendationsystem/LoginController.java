package com.example.newsrecommendationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private UserRepository userRepository = new UserRepository(new DatabaseManager());

    @FXML
    protected TextField usernameField;
    @FXML
    protected TextField passwordField;
    @FXML
    protected Label errorMessage;

    public void onLogin(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username, password);
        if (userRepository.doesUsernameExist(user.getUsername())) {
            if (userRepository.authenticateUser(user.getUsername(), user.getPassword())) {
                UserSession session = UserSession.getInstance();
                session.setUsername(user.getUsername());
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("preferred-articles.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
            } else {
                errorMessage.setText("Invalid Password");
            }
        } else {
            errorMessage.setText("Invalid Username. Register to log in");
        }

        /*Check if username exists in database*/
        /*Check if password correlates to existing password in database*/
    }

    public void onCancel(ActionEvent event){
        usernameField.clear();
        passwordField.clear();

    }

    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void onSignUpButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
