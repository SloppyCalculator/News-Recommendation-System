package com.example.newsrecommendationsystem.Controller;

import com.example.newsrecommendationsystem.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private void loadView(ActionEvent event, String fxmlFile) throws IOException {
        if (event == null) {
            throw new IllegalArgumentException("ActionEvent cannot be null");
        }

        Object source = event.getSource();
        if (!(source instanceof Node)) {
            System.err.println("Event source is not a valid JavaFX Node. Cannot proceed.");
            return; // Exit the method gracefully.
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            System.err.println("Failed to load FXML file: " + fxmlFile);
            e.printStackTrace();
            throw e; // Re-throw the exception after logging
        }

        Stage stage = (Stage) ((Node) source).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onLoginButtonClick(ActionEvent event) throws IOException {
        loadView(event, "login-view.fxml");
    }

    public void onSignUpButtonClick(ActionEvent event) throws IOException {
        loadView(event, "register-view.fxml");
    }

    public void onAdminButtonClick(ActionEvent event) throws IOException {
        loadView(event, "admin-login-view.fxml");
    }
}
