package com.example.newsrecommendationsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public final class UserArticleInteractionTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.getAction

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getAction()

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#getAction()}
     * @utbot.returnsFrom {@code return action;}
     */
    @Test
    @DisplayName("getAction: -> return action")
    public void testGetAction_ReturnAction() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, 0, null, null);

        String actual = userArticleInteraction.getAction();

        assertNull(actual);
    }
    ///endregion

    ///region Errors report for getAction

    public void testGetAction_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.getArticleId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getArticleId()

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#getArticleId()}
     * @utbot.returnsFrom {@code return articleId;}
     */
    @Test
    @DisplayName("getArticleId: -> return articleId")
    public void testGetArticleId_ReturnArticleId() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, -255, null, null);

        int actual = userArticleInteraction.getArticleId();

        assertEquals(-255, actual);
    }
    ///endregion

    ///region Errors report for getArticleId

    public void testGetArticleId_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.getTimestamp

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getTimestamp()

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#getTimestamp()}
     * @utbot.returnsFrom {@code return timestamp;}
     */
    @Test
    @DisplayName("getTimestamp: -> return timestamp")
    public void testGetTimestamp_ReturnTimestamp() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, 0, null, null);

        Timestamp actual = userArticleInteraction.getTimestamp();

        assertNull(actual);
    }
    ///endregion

    ///region Errors report for getTimestamp

    public void testGetTimestamp_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.getUserId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getUserId()

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#getUserId()}
     * @utbot.returnsFrom {@code return userId;}
     */
    @Test
    @DisplayName("getUserId: -> return userId")
    public void testGetUserId_ReturnUserId() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(-255, 0, null, null);

        int actual = userArticleInteraction.getUserId();

        assertEquals(-255, actual);
    }
    ///endregion

    ///region Errors report for getUserId

    public void testGetUserId_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.setAction

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setAction(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#setAction(String)}
     */
    @Test
    @DisplayName("setAction: ")
    public void testSetAction() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, 0, null, null);

        userArticleInteraction.setAction(null);
    }
    ///endregion

    ///region Errors report for setAction

    public void testSetAction_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 2 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.setArticleId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setArticleId(int)

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#setArticleId(int)}
     */
    @Test
    @DisplayName("setArticleId: ")
    public void testSetArticleId() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, -255, null, null);

        userArticleInteraction.setArticleId(-255);
    }
    ///endregion

    ///region Errors report for setArticleId

    public void testSetArticleId_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 2 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.setTimestamp

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setTimestamp(java.sql.Timestamp)

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#setTimestamp(Timestamp)}
     */
    @Test
    @DisplayName("setTimestamp: ")
    public void testSetTimestamp() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, 0, null, null);

        userArticleInteraction.setTimestamp(null);
    }
    ///endregion

    ///region Errors report for setTimestamp

    public void testSetTimestamp_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteraction.setUserId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setUserId(int)

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#setUserId(int)}
     */
    @Test
    @DisplayName("setUserId: ")
    public void testSetUserId() {
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(-255, 0, null, null);

        userArticleInteraction.setUserId(-255);
    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method setUserId(int)

    /**
     * @utbot.classUnderTest {@link UserArticleInteraction}
     * @utbot.methodUnderTest {@link UserArticleInteraction#setUserId(int)}
     */
    @Test
    @DisplayName("setUserId: userId = 16777217 (mutated from positive)")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testSetUserId1() {
        Timestamp timestamp = new Timestamp(1, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 1, Integer.MAX_VALUE, 0);
        timestamp.setNanos(Integer.MAX_VALUE);
        UserArticleInteraction userArticleInteraction = new UserArticleInteraction(Integer.MAX_VALUE, Integer.MAX_VALUE, "-3", timestamp);
        userArticleInteraction.setArticleId(-1);
        Timestamp timestamp1 = new Timestamp(-1L);
        timestamp1.setNanos(Integer.MIN_VALUE);
        userArticleInteraction.setTimestamp(timestamp1);
        userArticleInteraction.setUserId(Integer.MAX_VALUE);
        userArticleInteraction.setAction("-3");
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> userArticleInteraction.setUserId(16777217));
    }
    ///endregion

    ///region Errors report for setUserId

    public void testSetUserId_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // Default concrete execution failed

    }
    ///endregion

    ///endregion
}
