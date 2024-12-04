package com.example.newsrecommendationsystem;

import com.example.newsrecommendationsystem.Controller.HelloController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.Context;

import java.io.IOException;

import static org.mockito.Mockito.mockConstruction;

public final class HelloControllerTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.Controller.HelloController.onAdminButtonClick

    ///region FUZZER: ERROR SUITE for method onAdminButtonClick(javafx.event.ActionEvent)

    /**
     * @utbot.classUnderTest {@link HelloController}
     * @utbot.methodUnderTest {@link HelloController#onAdminButtonClick(ActionEvent)}
     */
    @Test
    @DisplayName("onAdminButtonClick: event = ActionEvent() -> throw ClassCastException")
    public void testOnAdminButtonClickThrowsCCE() throws IOException {
        HelloController helloController = new HelloController();
        ActionEvent event = new ActionEvent();
        
        /* This test fails because method [com.example.newsrecommendationsystem.Controller.HelloController.onAdminButtonClick] produces [java.lang.ClassCastException: class javafx.event.Event$$Lambda$89/0x000000f80130c400 cannot be cast to class javafx.scene.Node (javafx.event.Event$$Lambda$89/0x000000f80130c400 and javafx.scene.Node are in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @57589799)]
            com.example.newsrecommendationsystem.Controller.HelloController.onAdminButtonClick(HelloController.java:35) */
        helloController.onAdminButtonClick(event);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method onAdminButtonClick(javafx.event.ActionEvent)

    @Test
    public void testOnAdminButtonClick1() throws IOException {
        MockedConstruction mockedConstruction = null;
        try {
            mockedConstruction = mockConstruction(FXMLLoader.class, (FXMLLoader fXMLLoaderMock, Context context) -> {
            });
            HelloController helloController = new HelloController();
            
            /* This test fails because method [com.example.newsrecommendationsystem.Controller.HelloController.onAdminButtonClick] produces [java.lang.NullPointerException]
                com.example.newsrecommendationsystem.Controller.HelloController.onAdminButtonClick(HelloController.java:35) */
            helloController.onAdminButtonClick(null);
        } finally {
            mockedConstruction.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Controller.HelloController.onLoginButtonClick

    ///region FUZZER: ERROR SUITE for method onLoginButtonClick(javafx.event.ActionEvent)

    /**
     * @utbot.classUnderTest {@link HelloController}
     * @utbot.methodUnderTest {@link HelloController#onLoginButtonClick(ActionEvent)}
     */
    @Test
    @DisplayName("onLoginButtonClick: event = ActionEvent() -> throw ClassCastException")
    public void testOnLoginButtonClickThrowsCCE() throws IOException {
        HelloController helloController = new HelloController();
        ActionEvent event = new ActionEvent();
        
        /* This test fails because method [com.example.newsrecommendationsystem.Controller.HelloController.onLoginButtonClick] produces [java.lang.ClassCastException: class javafx.event.Event$$Lambda$89/0x000000f80130c400 cannot be cast to class javafx.scene.Node (javafx.event.Event$$Lambda$89/0x000000f80130c400 and javafx.scene.Node are in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @57589799)]
            com.example.newsrecommendationsystem.Controller.HelloController.onLoginButtonClick(HelloController.java:19) */
        helloController.onLoginButtonClick(event);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method onLoginButtonClick(javafx.event.ActionEvent)

    @Test
    public void testOnLoginButtonClick1() throws IOException {
        MockedConstruction mockedConstruction = null;
        try {
            mockedConstruction = mockConstruction(FXMLLoader.class, (FXMLLoader fXMLLoaderMock, Context context) -> {
            });
            HelloController helloController = new HelloController();
            
            /* This test fails because method [com.example.newsrecommendationsystem.Controller.HelloController.onLoginButtonClick] produces [java.lang.NullPointerException]
                com.example.newsrecommendationsystem.Controller.HelloController.onLoginButtonClick(HelloController.java:19) */
            helloController.onLoginButtonClick(null);
        } finally {
            mockedConstruction.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Controller.HelloController.onSignUpButtonClick

    ///region FUZZER: ERROR SUITE for method onSignUpButtonClick(javafx.event.ActionEvent)

    /**
     * @utbot.classUnderTest {@link HelloController}
     * @utbot.methodUnderTest {@link HelloController#onSignUpButtonClick(ActionEvent)}
     */
    @Test
    @DisplayName("onSignUpButtonClick: event = ActionEvent() -> throw ClassCastException")
    public void testOnSignUpButtonClickThrowsCCE() throws IOException {
        HelloController helloController = new HelloController();
        ActionEvent event = new ActionEvent();
        
        /* This test fails because method [com.example.newsrecommendationsystem.Controller.HelloController.onSignUpButtonClick] produces [java.lang.ClassCastException: class javafx.event.Event$$Lambda$89/0x000000f80130c400 cannot be cast to class javafx.scene.Node (javafx.event.Event$$Lambda$89/0x000000f80130c400 and javafx.scene.Node are in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @57589799)]
            com.example.newsrecommendationsystem.Controller.HelloController.onSignUpButtonClick(HelloController.java:27) */
        helloController.onSignUpButtonClick(event);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method onSignUpButtonClick(javafx.event.ActionEvent)

    @Test
    public void testOnSignUpButtonClick1() throws IOException {
        MockedConstruction mockedConstruction = null;
        try {
            mockedConstruction = mockConstruction(FXMLLoader.class, (FXMLLoader fXMLLoaderMock, Context context) -> {
            });
            HelloController helloController = new HelloController();
            
            /* This test fails because method [com.example.newsrecommendationsystem.Controller.HelloController.onSignUpButtonClick] produces [java.lang.NullPointerException]
                com.example.newsrecommendationsystem.Controller.HelloController.onSignUpButtonClick(HelloController.java:27) */
            helloController.onSignUpButtonClick(null);
        } finally {
            mockedConstruction.close();
        }
    }
    ///endregion

    ///endregion
}
