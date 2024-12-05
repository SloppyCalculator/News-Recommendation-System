package com.example.newsrecommendationsystem;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ReaderController {

    @FXML
    private Label userLabel;

    @FXML
    private TableView<Article> articlesTable;

    @FXML
    private TableColumn<Article, String> titleColumn;

    @FXML
    private TableColumn<Article, Void> actionColumn;
    @FXML
    private Button logOut;
    private TableView<Article> tableView;
    private final UserRepository userRepository = new UserRepository(new DatabaseManager());
    private final ArticleRepository articleRepository = new ArticleRepository(new DatabaseManager());
    private final UserArticleInteractionRepository userArticleInteractionRepository =
            new UserArticleInteractionRepository(new DatabaseManager());
    private final UserSession userSession = UserSession.getInstance();
    public void initialize() {
        // Initialize userLabel with the current user's username
        UserSession session = UserSession.getInstance();
        userLabel.setText(session.getUsername());
        logOut.setText("LOG OUT");
        logOut.setPrefWidth(100.00);

        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        // Get user preferences
        ArrayList<String> preferences = user.getPreferences();
        if (preferences == null || preferences.isEmpty()) {
            showFeedback("No preferences found. Loading default articles.");
            ArrayList<Article> articles = articleRepository.getAllArticles();
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            articlesTable.getItems().addAll(articles);
        } else {
            ArrayList<Article> articles = articleRepository.getArticlesByCategoryPreferences(preferences);

            // Populate the TableView if articles are found
            if (articles != null && !articles.isEmpty()) {
                titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
                articlesTable.getItems().addAll(articles);
            } else {
                showFeedback("No articles available for your preferences.");
            }
        }

        // Add action buttons to the TableView
        addActionButtons(); // This handles the actionColumn setup.
    }

    private void addActionButtons() {
        actionColumn.setCellFactory(column -> new TableCell<>() {
            private final Button readButton = new Button("\uD83D\uDC41"); // 👁
            private final Button likeButton = new Button("\uD83D\uDC4D"); // 👍
            private final Button skipButton = new Button("\u274C");      // ❌
            private final HBox buttonBox = new HBox(10, readButton, likeButton, skipButton); // Adjust spacing

            {
                // Style the HBox
                buttonBox.setStyle("-fx-alignment: center; -fx-padding: 5;");

                // Ensure font supports emojis
                String emojiFont = "-fx-font-family: 'Segoe UI Emoji', 'Arial'; -fx-font-size: 14;";
                readButton.setStyle(emojiFont);
                likeButton.setStyle(emojiFont);
                skipButton.setStyle(emojiFont);

                // Apply CSS classes to buttons for additional styling (optional)
                readButton.getStyleClass().add("read-button");
                likeButton.getStyleClass().add("like-button");
                skipButton.getStyleClass().add("skip-button");

                // Button actions
                readButton.setOnAction(event -> {
                    Article article = getTableView().getItems().get(getIndex());
                    readArticle(article);
                });

                likeButton.setOnAction(event -> {
                    Article article = getTableView().getItems().get(getIndex());
                    likeArticle(article);
                });

                skipButton.setOnAction(event -> {
                    Article article = getTableView().getItems().get(getIndex());
                    skipArticle(article);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(buttonBox);
                    setMinWidth(200); // Adjust to ensure enough space for buttons
                }
            }
        });
    }

    private void readArticle(Article article) {
        // Implement the read action
        User user = userRepository.loadUserByUsername(userSession.getUsername());
        showFeedback("Read article: " + article.getTitle());
        userArticleInteractionRepository.recordUserAction(user.getUserID(), article.getId(), "read");
        String content = article.scrapeArticleContent(article.getLink());
        openArticleWindow(article.getTitle(), content);

    }


    private void openArticleWindow(String title, String content) {
        // Create a new Stage (window)
        Stage articleStage = new Stage();
        articleStage.setTitle("Reading: " + title);

        // Create a TextArea to display the article content
        TextArea articleTextArea = new TextArea(content);
        articleTextArea.setWrapText(true);  // Wrap text for better readability
        articleTextArea.setPrefHeight(400);  // Increase the height of the TextArea

        articleTextArea.setEditable(false); // Make it read-only

        // Create a VBox layout and add the TextArea
        VBox vbox = new VBox(articleTextArea);
        vbox.setSpacing(10);

        // Set up a scene with the VBox layout
        Scene articleScene = new Scene(vbox, 600, 400); // 600x400 window size
        articleStage.setScene(articleScene);

        // Show the article window
        articleStage.show();
    }

    private void likeArticle(Article article) {
        // Implement the like action
        UserSession session = UserSession.getInstance();
        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        userArticleInteractionRepository.recordUserAction(user.getUserID(), article.getId(), "liked");
        showFeedback("Liked article: " + article.getTitle());
    }

    private void skipArticle(Article article) {
        UserSession session = UserSession.getInstance();
        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        userArticleInteractionRepository.recordUserAction(user.getUserID(), article.getId(), "skipped");
        // Implement the skip action
        showFeedback("Skipped article: " + article.getTitle());
        // Remove the skipped article from the table
        articlesTable.getItems().remove(article);
    }

    private void showFeedback(String message) {
        // Display feedback to the user
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleViewArticlesClick(ActionEvent event) {
        // Fetch the current user session
        UserSession session = UserSession.getInstance();
        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        int userId = user.getUserID(); // Get the current user ID

        String action = "read"; // Define the action type
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(new DatabaseManager());
        ArticleRepository articleRepository = new ArticleRepository(new DatabaseManager());

        // Load the user's actions
        List<UserArticleInteraction> userActions = userArticleInteractionRepository.loadUserActionsByAction(userId, action);

        // Fetch articles related to user actions
        List<Article> articles = new ArrayList<>();
        for (UserArticleInteraction userAction : userActions) {
            Article article = articleRepository.getArticleById(userAction.getArticleId());
            if (article != null) {
                articles.add(article); // Add to the list if the article is found
            }
        }

        // Create a new Stage (window) for displaying the articles
        Stage stage = new Stage();
        stage.setTitle("Articles Read");

        // Create a TableView to display the articles
        TableView<Article> tableView = new TableView<>();

        // Define the column for the TableView to display the article title
        TableColumn<Article, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Create a "Read Article" button column
        TableColumn<Article, Void> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button readButton = new Button("Read Article");

            {
                readButton.setOnAction(e -> {
                    Article article = getTableView().getItems().get(getIndex());
                    if (article != null) {
                        // Handle the "Read Article" action
                        readArticle(article);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(readButton);
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

    @FXML
    private void handleLikedArticlesClick(ActionEvent event) {
        // Fetch the current user session
        UserSession session = UserSession.getInstance();
        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        int userId = user.getUserID(); // Get the current user ID

        String action = "liked"; // Define the action type
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(new DatabaseManager());
        ArticleRepository articleRepository = new ArticleRepository(new DatabaseManager());

        // Load the user's actions
        List<UserArticleInteraction> userActions = userArticleInteractionRepository.loadUserActionsByAction(userId, action);

        // Fetch articles related to user actions
        List<Article> articles = new ArrayList<>();
        for (UserArticleInteraction userAction : userActions) {
            Article article = articleRepository.getArticleById(userAction.getArticleId());
            if (article != null) {
                articles.add(article); // Add to the list if the article is found
            }
        }

        // Create a new Stage (window) for displaying the articles
        Stage stage = new Stage();
        stage.setTitle("Articles Liked");

        // Create a TableView to display the articles
        tableView = new TableView<>();

        // Define the column for the TableView to display the article title
        TableColumn<Article, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Create a "Read Article" button column
        TableColumn<Article, Void> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button readButton = new Button("Read Article");
            private final Button removeLikeButton = new Button("Remove Like");
            private final HBox buttonBox = new HBox(10, readButton, removeLikeButton); // Add spacing between buttons

            {
                readButton.setOnAction(e -> {
                    Article article = getTableView().getItems().get(getIndex());
                    if (article != null) {
                        // Handle the "Read Article" action
                        readArticle(article);
                    }
                });

                // Handle "Remove Like" button action
                removeLikeButton.setOnAction(e -> {
                    Article article = getTableView().getItems().get(getIndex());
                    if (article != null) {
                        removeLike(article);
                    }
                });

                // Optional styling for the HBox
                buttonBox.setStyle("-fx-alignment: center;");
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(buttonBox);
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

    @FXML
    private void handleSkippedArticlesClick(ActionEvent event) {
        // Fetch the current user session
        UserSession session = UserSession.getInstance();
        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        int userId = user.getUserID(); // Get the current user ID

        String action = "skipped"; // Define the action type
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(new DatabaseManager());
        ArticleRepository articleRepository = new ArticleRepository(new DatabaseManager());

        // Load the user's actions
        List<UserArticleInteraction> userActions = userArticleInteractionRepository.loadUserActionsByAction(userId, action);

        // Fetch articles related to user actions
        List<Article> articles = new ArrayList<>();
        for (UserArticleInteraction userAction : userActions) {
            Article article = articleRepository.getArticleById(userAction.getArticleId());
            if (article != null) {
                articles.add(article); // Add to the list if the article is found
            }
        }

        // Create a new Stage (window) for displaying the articles
        Stage stage = new Stage();
        stage.setTitle("Articles Skipped");

        // Create a TableView to display the articles
        tableView = new TableView<>();

        // Define the column for the TableView to display the article title
        TableColumn<Article, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Create a "Read Article" button column
        TableColumn<Article, Void> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button readButton = new Button("Read Article");
            private final Button removeSkipButton = new Button("Remove Skip");
            private final HBox buttonBox = new HBox(10, readButton, removeSkipButton); // Add spacing between buttons

            {
                readButton.setOnAction(e -> {
                    Article article = getTableView().getItems().get(getIndex());
                    if (article != null) {
                        // Handle the "Read Article" action
                        readArticle(article);
                    }
                });

                // Handle "Remove Skip" button action
                removeSkipButton.setOnAction(e -> {
                    Article article = getTableView().getItems().get(getIndex());
                    if (article != null) {
                        removeSkip(article);
                    }
                });

                // Optional styling for the HBox
                buttonBox.setStyle("-fx-alignment: center;");
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(buttonBox);
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

    public void removeLike(Article article){
        User user = userRepository.loadUserByUsername(userSession.getUsername());
        // Print confirmation
        if(userArticleInteractionRepository.removeUserAction(user.getUserID(), article.getId(), "liked")){
            showAlert("Success", "Successfully removed from liked articles");
        }
        ObservableList<Article> currentList = tableView.getItems();
        currentList.remove(article); // Remove the unliked article
        tableView.setItems(FXCollections.observableArrayList(currentList)); // Update Table

    }

    public void removeSkip(Article article){
        User user = userRepository.loadUserByUsername(userSession.getUsername());
        // Print confirmation
        if(userArticleInteractionRepository.removeUserAction(user.getUserID(), article.getId(), "skipped")){
            showAlert("Success", "Successfully removed from skipped articles");
        }
        ObservableList<Article> currentList = tableView.getItems();
        currentList.remove(article); // Remove the skipped article
        tableView.setItems(FXCollections.observableArrayList(currentList)); // Update Table

    }

    public void openUserProfileWindow() {
        String username = UserSession.getInstance().getUsername();
        User user = userRepository.loadUserByUsername(username);
        // Create a new Stage (Window)
        Stage profileStage = new Stage();
        profileStage.setTitle("User Profile");

        // Create a layout (VBox for vertical arrangement)
        VBox vBox = new VBox(15); // 15px gap between elements
        vBox.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0; -fx-alignment: center;");

        // Add buttons for changing username and password with styles
        Button changeUsernameButton = new Button("Change Username");
        Button changePasswordButton = new Button("Change Password");
        Button cancelButton = new Button("Cancel");

        // Apply CSS styling to buttons
        changeUsernameButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");
        changePasswordButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");
        cancelButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #f44336; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");

        // Center buttons and add them to the VBox
        vBox.getChildren().addAll(changeUsernameButton, changePasswordButton, cancelButton);

        // Set action for changing username
        changeUsernameButton.setOnAction(event -> openChangeUsernameWindow(user));

        // Set action for changing password
        changePasswordButton.setOnAction(event -> openChangePasswordWindow(user));

        // Set action for cancel button
        cancelButton.setOnAction(event -> profileStage.close());

        // Create a scene and set it to the stage
        Scene scene = new Scene(vBox, 400, 250);
        profileStage.setScene(scene);

        // Show the window
        profileStage.show();
    }

    private void openChangeUsernameWindow(User user) {
        // Create a new Stage (Window)
        Stage usernameStage = new Stage();
        usernameStage.setTitle("Change Username");

        // Create a layout (VBox for vertical arrangement)
        VBox vBox = new VBox(15); // 15px gap between elements
        vBox.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0; -fx-alignment: center;");

        // Add components to the layout
        Label newUsernameLabel = new Label("New Username: ");
        TextField newUsernameField = new TextField();

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        // Apply CSS styling to the components
        newUsernameLabel.setStyle("-fx-font-size: 14px;");
        newUsernameField.setStyle("-fx-font-size: 14px; -fx-padding: 10;");

        saveButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");
        cancelButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #f44336; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");

        // Center components and add them to the VBox
        vBox.getChildren().addAll(newUsernameLabel, newUsernameField, saveButton, cancelButton);

        // Set button actions
        saveButton.setOnAction(event -> {
            String newUsername = newUsernameField.getText();

            if (newUsername.isEmpty()) {
                showAlert("Error", "Username cannot be empty.");
                return;
            }
            // Changes username
            if(!userRepository.doesUsernameExist(newUsername)) {
                userRepository.updateUsername(user.getUserID(), newUsername);
                UserSession userSession = UserSession.getInstance();
                userSession.setUsername(newUsername);
                userLabel.setText(newUsername);
            // If username exists in database
            }else{
                showAlert("Failed", "Username already exists. Try again");
                return;
            }
            // Show confirmation
            showAlert("Success", "Username updated successfully.");
            usernameStage.close();
        });

        cancelButton.setOnAction(event -> usernameStage.close());

        // Create a scene and set it to the stage
        Scene scene = new Scene(vBox, 300, 200);
        usernameStage.setScene(scene);

        // Show the window
        usernameStage.show();
    }

    private void openChangePasswordWindow(User user) {
        // Create a new Stage (Window)
        Stage passwordStage = new Stage();
        passwordStage.setTitle("Change Password");

        // Create a layout (VBox for vertical arrangement)
        VBox vBox = new VBox(15); // 15px gap between elements
        vBox.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0; -fx-alignment: center;");

        // Add components to the layout
        Label currentPasswordLabel = new Label("Current Password: ");
        PasswordField currentPasswordField = new PasswordField();

        Label newPasswordLabel = new Label("New Password: ");
        PasswordField newPasswordField = new PasswordField();

        Label confirmPasswordLabel = new Label("Confirm New Password: ");
        PasswordField confirmPasswordField = new PasswordField();

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        // Apply CSS styling to the components
        currentPasswordLabel.setStyle("-fx-font-size: 14px;");
        newPasswordLabel.setStyle("-fx-font-size: 14px;");
        confirmPasswordLabel.setStyle("-fx-font-size: 14px;");

        currentPasswordField.setStyle("-fx-font-size: 14px; -fx-padding: 10;");
        newPasswordField.setStyle("-fx-font-size: 14px; -fx-padding: 10;");
        confirmPasswordField.setStyle("-fx-font-size: 14px; -fx-padding: 10;");

        saveButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");
        cancelButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20; -fx-background-color: #f44336; -fx-text-fill: white; -fx-border-radius: 5; -fx-background-radius: 5;");

        // Center components and add them to the VBox
        vBox.getChildren().addAll(currentPasswordLabel, currentPasswordField, newPasswordLabel, newPasswordField, confirmPasswordLabel, confirmPasswordField, saveButton, cancelButton);

        // Set button actions
        saveButton.setOnAction(event -> {
            String currentPassword = currentPasswordField.getText();
            String newPassword = newPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                showAlert("Error", "All fields must be filled out.");
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                showAlert("Error", "New password and confirmation do not match.");
                return;
            }

            // Replace with actual logic for changing password
            if (user.verifyPassword(currentPassword)) {
                User user1 = new User(user.getUsername(), newPassword);
                userRepository.updatePassword(user.getUserID(), user1.getPassword());
                showAlert("Success", "Password updated successfully.");
                passwordStage.close();
            } else {
                showAlert("Error", "Current password is incorrect.");
            }
        });

        cancelButton.setOnAction(event -> passwordStage.close());

        // Create a scene and set it to the stage
        Scene scene = new Scene(vBox, 400, 600);
        passwordStage.setScene(scene);

        // Show the window
        passwordStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleManagePreferencesClick(ActionEvent event) {
        // Fetch the current user session
        UserSession session = UserSession.getInstance();
        UserRepository userRepository = new UserRepository(new DatabaseManager());
        User user = userRepository.loadUserByUsername(session.getUsername());
        int userId = user.getUserID(); // Get the current user ID

        // Load the user's current preferences
        ArrayList<String> userPreferences = user.getPreferences();

        // Create a new Stage (window) for managing preferences
        Stage preferencesStage = new Stage();
        preferencesStage.setTitle("Manage Preferences");

        // Create a VBox layout to hold the checkboxes and buttons
        VBox vbox = new VBox(20); // 20px spacing between elements
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20)); // Padding around the VBox

        // Create a Label for the title
        Label titleLabel = new Label("Select Your Preferences");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #4CAF50;");

        // Create CheckBox elements for each preference
        CheckBox politicsSelect = new CheckBox("Politics");
        politicsSelect.setSelected(userPreferences.contains("Politics"));
        CheckBox entertainmentSelect = new CheckBox("Entertainment");
        entertainmentSelect.setSelected(userPreferences.contains("Entertainment"));
        CheckBox sportsSelect = new CheckBox("Sports");
        sportsSelect.setSelected(userPreferences.contains("Sports"));
        CheckBox technologySelect = new CheckBox("Technology");
        technologySelect.setSelected(userPreferences.contains("Technology"));
        CheckBox healthSelect = new CheckBox("Health");
        healthSelect.setSelected(userPreferences.contains("Health"));
        CheckBox businessSelect = new CheckBox("Business");
        businessSelect.setSelected(userPreferences.contains("Business"));
        CheckBox lifestyleSelect = new CheckBox("LifeStyle");
        lifestyleSelect.setSelected(userPreferences.contains("LifeStyle"));
        CheckBox educationSelect = new CheckBox("Education");
        educationSelect.setSelected(userPreferences.contains("Education"));

        // Create Submit and Cancel buttons
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px;");

        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px 20px;");

        // Add action to Cancel button to close the preferences window
        cancelButton.setOnAction(e -> preferencesStage.close());

        // Add action to Submit button to save the selected preferences
        submitButton.setOnAction(e -> {
            // Collect the selected preferences
            ArrayList<String> selectedPreferences = new ArrayList<>();
            if (politicsSelect.isSelected()) selectedPreferences.add("Politics");
            if (entertainmentSelect.isSelected()) selectedPreferences.add("Entertainment");
            if (sportsSelect.isSelected()) selectedPreferences.add("Sports");
            if (technologySelect.isSelected()) selectedPreferences.add("Technology");
            if (healthSelect.isSelected()) selectedPreferences.add("Health");
            if (businessSelect.isSelected()) selectedPreferences.add("Business");
            if (lifestyleSelect.isSelected()) selectedPreferences.add("LifeStyle");
            if (educationSelect.isSelected()) selectedPreferences.add("Education");

            // Save the selected preferences to the database or session
            userRepository.saveUserPreferences(userId, selectedPreferences);
            showAlert("Preferences Updated", "Your preferences were successfully updated");
            initialize();
            // Close the preferences window
            preferencesStage.close();

        });

        // Arrange the controls in the VBox layout
        vbox.getChildren().addAll(titleLabel, politicsSelect, entertainmentSelect, sportsSelect, technologySelect,
                healthSelect, businessSelect, lifestyleSelect, educationSelect, submitButton, cancelButton);

        // Add spacing between the buttons
        VBox.setMargin(submitButton, new Insets(10, 0, 10, 0)); // margin for submit button
        VBox.setMargin(cancelButton, new Insets(10, 0, 0, 0)); // margin for cancel button

        // Set up the scene with a light background color and center it on screen
        Scene scene = new Scene(vbox, 400, 500);
        scene.setFill(Color.LIGHTGRAY);

        // Set the stage properties and show the preferences window
        preferencesStage.setScene(scene);
        preferencesStage.centerOnScreen();
        preferencesStage.show();
    }

    public void onLogOut(Event event) throws IOException {
        UserSession.getInstance().clearSession();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSwitchClick(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("read-articles.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }







}

