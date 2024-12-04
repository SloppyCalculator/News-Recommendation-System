package com.example.newsrecommendationsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class UserSessionTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.UserSession.clearSession

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method clearSession()

    /**
     * @utbot.classUnderTest {@link UserSession}
     * @utbot.methodUnderTest {@link UserSession#clearSession()}
     */
    @Test
    @DisplayName("clearSession: ")
    public void testClearSession() throws Exception {
        Class userSessionClazz = Class.forName("com.example.newsrecommendationsystem.UserSession");
        UserSession prevInstance = ((UserSession) getStaticFieldValue(userSessionClazz, "instance"));
        try {
            setStaticField(userSessionClazz, "instance", null);
            UserSession userSession = ((UserSession) createInstance("com.example.newsrecommendationsystem.UserSession"));

            userSession.clearSession();
        } finally {
            setStaticField(UserSession.class, "instance", prevInstance);
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserSession.getInstance

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getInstance()

    /**
     * @utbot.classUnderTest {@link UserSession}
     * @utbot.methodUnderTest {@link UserSession#getInstance()}
     * @utbot.executesCondition {@code (instance == null): True}
     * @utbot.returnsFrom {@code return instance;}
     */
    @Test
    @DisplayName("getInstance: instance == null : True -> return instance")
    public void testGetInstance_InstanceEqualsNull() throws Exception {
        Class userSessionClazz = Class.forName("com.example.newsrecommendationsystem.UserSession");
        UserSession prevInstance = ((UserSession) getStaticFieldValue(userSessionClazz, "instance"));
        try {
            setStaticField(userSessionClazz, "instance", null);

            UserSession actual = UserSession.getInstance();

            UserSession expected = ((UserSession) createInstance("com.example.newsrecommendationsystem.UserSession"));

        } finally {
            setStaticField(UserSession.class, "instance", prevInstance);
        }
    }

    /**
     * @utbot.classUnderTest {@link UserSession}
     * @utbot.methodUnderTest {@link UserSession#getInstance()}
     * @utbot.executesCondition {@code (instance == null): False}
     * @utbot.returnsFrom {@code return instance;}
     */
    @Test
    @DisplayName("getInstance: instance == null : False -> return instance")
    public void testGetInstance_InstanceNotEqualsNull() throws Exception {
        Class userSessionClazz = Class.forName("com.example.newsrecommendationsystem.UserSession");
        UserSession prevInstance = ((UserSession) getStaticFieldValue(userSessionClazz, "instance"));
        try {
            UserSession instance = ((UserSession) createInstance("com.example.newsrecommendationsystem.UserSession"));
            setStaticField(userSessionClazz, "instance", instance);

            UserSession actual = UserSession.getInstance();

            String actualUsername = actual.getUsername();
            assertNull(actualUsername);

        } finally {
            setStaticField(UserSession.class, "instance", prevInstance);
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserSession.getUsername

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getUsername()

    /**
     * @utbot.classUnderTest {@link UserSession}
     * @utbot.methodUnderTest {@link UserSession#getUsername()}
     * @utbot.returnsFrom {@code return username;}
     */
    @Test
    @DisplayName("getUsername: -> return username")
    public void testGetUsername_ReturnUsername() throws Exception {
        UserSession userSession = ((UserSession) createInstance("com.example.newsrecommendationsystem.UserSession"));

        String actual = userSession.getUsername();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserSession.setUsername

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserSession}
     * @utbot.methodUnderTest {@link UserSession#setUsername(String)}
     */
    @Test
    @DisplayName("setUsername: ")
    public void testSetUsername() throws Exception {
        UserSession userSession = ((UserSession) createInstance("com.example.newsrecommendationsystem.UserSession"));

        userSession.setUsername(null);
    }
    ///endregion

    ///endregion
}
