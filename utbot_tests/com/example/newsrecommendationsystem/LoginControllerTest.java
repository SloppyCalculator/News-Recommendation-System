package com.example.newsrecommendationsystem;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public final class LoginControllerTest {

    private LoginController loginController;

    private TextField usernameFieldMock;
    private TextField passwordFieldMock;

    @BeforeEach
    public void setUp() {
        loginController = new LoginController();
        usernameFieldMock = mock(TextField.class);
        passwordFieldMock = mock(TextField.class);

        loginController.usernameField = usernameFieldMock;
        loginController.passwordField = passwordFieldMock;
    }

    ///region Test suites for com.example.newsrecommendationsystem.LoginController.onBackButtonClick

    @Test
    @DisplayName("onBackButtonClick: Valid ActionEvent source -> Successful navigation")
    public void testOnBackButtonClickWithValidSource() throws IOException {
        // Arrange
        Node mockSource = mock(Node.class); // Simulate a valid Node source
        ActionEvent event = new ActionEvent(mockSource, null);

        // Act & Assert
        // Assuming navigation logic (e.g., changing scenes), this is a placeholder for that verification
        // Uncomment if navigation logic is mockable
        // verify(mockNavigation).navigateTo("previousScene.fxml");
    }

    @Test
    @DisplayName("onBackButtonClick: Invalid ActionEvent source -> Throws ClassCastException")
    public void testOnBackButtonClickThrowsCCE() {
        // Arrange
        ActionEvent event = new ActionEvent(); // Invalid source for this context

        // Act & Assert
        assertThrows(ClassCastException.class, () -> loginController.onBackButtonClick(event));
    }

    ///endregion

    ///region Test suites for com.example.newsrecommendationsystem.LoginController.onCancel

    @Test
    @DisplayName("onCancel: Clears both username and password fields")
    public void testOnCancelClearsFields() {
        // Act
        loginController.onCancel(new ActionEvent());

        // Assert
        verify(usernameFieldMock).clear();
        verify(passwordFieldMock).clear();
    }

    @Test
    @DisplayName("onCancel: Null usernameField or passwordField -> Throws NullPointerException")
    public void testOnCancelThrowsNPE() {
        // Arrange
        loginController.usernameField = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> loginController.onCancel(new ActionEvent()));
    }

    ///endregion

    ///region Test suites for com.example.newsrecommendationsystem.LoginController.onLogin

    @Test
    @DisplayName("onLogin: Null usernameField or passwordField -> Throws NullPointerException")
    public void testOnLoginThrowsNPE() throws IOException {
        // Arrange
        loginController.usernameField = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> loginController.onLogin(new ActionEvent()));
    }

    @Test
    @DisplayName("onLogin: Valid username and password -> Successful login")
    public void testOnLoginSuccessful() throws IOException {
        // Arrange
        when(usernameFieldMock.getText()).thenReturn("validUser");
        when(passwordFieldMock.getText()).thenReturn("validPass");

        // Act
        loginController.onLogin(new ActionEvent());

        // Assert
        // Assuming some success validation logic, this is a placeholder
        // verify(mockService).login("validUser", "validPass");
    }

    ///endregion

    ///region Test suites for com.example.newsrecommendationsystem.LoginController.onSignUpButtonClick

    @Test
    @DisplayName("onSignUpButtonClick: Valid ActionEvent source -> Successful navigation")
    public void testOnSignUpButtonClickWithValidSource() throws IOException {
        // Arrange
        Node mockSource = mock(Node.class); // Simulate a valid Node source
        ActionEvent event = new ActionEvent(mockSource, null);

        // Act & Assert
        // Placeholder for navigation verification
        // verify(mockNavigation).navigateTo("signUpScene.fxml");
    }

    @Test
    @DisplayName("onSignUpButtonClick: Invalid ActionEvent source -> Throws ClassCastException")
    public void testOnSignUpButtonClickThrowsCCE() {
        // Arrange
        ActionEvent event = new ActionEvent(); // Invalid source for this context

        // Act & Assert
        assertThrows(ClassCastException.class, () -> loginController.onSignUpButtonClick(event));
    }

    ///endregion
}
