package com.example.newsrecommendationsystem.Controller;

import com.example.newsrecommendationsystem.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdmInMainController {
    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private DatabaseManager databaseManager;
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

    public void deleteUser(User user){
        userRepository = new UserRepository(databaseManager);
        if(userRepository.deleteUserById(user.getUserID())){
            System.out.println("User removed successfully");
        }
        onManageUsers();
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

    public void deleteArticle(Article article){
        userRepository = new UserRepository(databaseManager);
        if(userRepository.deleteUserById(article.getId())){
            System.out.println("Article removed successfully");
        }
        onManageArticles();
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

}


