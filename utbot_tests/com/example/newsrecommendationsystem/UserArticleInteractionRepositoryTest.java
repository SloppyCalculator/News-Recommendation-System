package com.example.newsrecommendationsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.utbot.runtime.utils.java.UtUtils.deepEquals;

public final class UserArticleInteractionRepositoryTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteractionRepository.hasUserPerformedAction


    @Test
    public void testHasUserPerformedAction1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            boolean actual = userArticleInteractionRepository.hasUserPerformedAction(-255, -255, null);

            assertFalse(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#hasUserPerformedAction(int, int, String)}
     */
    @Test
    @DisplayName("hasUserPerformedAction: userId = -2147483647 (mutated from positive), articleId = -1, action = '\n\t\r' -> throw NullPointerException")
    public void testHasUserPerformedActionThrowsNPEWithBlankString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.hasUserPerformedAction(-2147483647, -1, "\n\t\r"));
    }

    @Test
    public void testHasUserPerformedAction2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.hasUserPerformedAction(-255, -255, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testHasUserPerformedAction3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.hasUserPerformedAction(-255, -255, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testHasUserPerformedAction4() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (when(preparedStatementMock.executeQuery())).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.hasUserPerformedAction(-255, -255, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method hasUserPerformedAction(int, int, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#hasUserPerformedAction(int, int, String)}
     */
    @Test
    @DisplayName("hasUserPerformedAction: hasUserPerformedAction: userId = -2147483647 (mutated from positive), articleId = -1, action = '\n\t\r' -> throw NullPointerException")
    public void testHasUserPerformedActionThrowsNPEWithBlankString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.hasUserPerformedAction(-2147483647, -1, "\n\t\r"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteractionRepository.loadArticleActions


    @Test
    public void testLoadArticleActions1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            ArrayList actual = ((ArrayList) userArticleInteractionRepository.loadArticleActions(-255));

            ArrayList expected = new ArrayList();

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadArticleActions2() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(true, false);
            (when(resultSetMock.getInt(any(String.class)))).thenReturn(0, 0);
            (when(resultSetMock.getString(any(String.class)))).thenReturn(((String) null));
            (when(resultSetMock.getTimestamp(any(String.class)))).thenReturn(((Timestamp) null));
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            ArrayList actual = ((ArrayList) userArticleInteractionRepository.loadArticleActions(-255));

            ArrayList expected = new ArrayList();
            UserArticleInteraction userArticleInteraction = new UserArticleInteraction(0, 0, null, null);
            expected.add(userArticleInteraction);

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#loadArticleActions(int)}
     */
    @Test
    @DisplayName("loadArticleActions: articleId = -3 (mutated from -1) -> throw NullPointerException")
    public void testLoadArticleActionsThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadArticleActions(-3));
    }

    @Test
    public void testLoadArticleActions3() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadArticleActions(-255));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadArticleActions4() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadArticleActions(-255));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadArticleActions5() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            (when(preparedStatementMock.executeQuery())).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadArticleActions(-255));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadArticleActions(int)

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#loadArticleActions(int)}
     */
    @Test
    @DisplayName("loadArticleActions: loadArticleActions: articleId = -3 (mutated from -1) -> throw NullPointerException")
    public void testLoadArticleActionsThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadArticleActions(-3));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteractionRepository.loadUserActions


    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#loadUserActions(int)}
     */
    @Test
    @DisplayName("loadUserActions: userId = -3 (mutated from -1) -> throw NullPointerException")
    public void testLoadUserActionsThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadUserActions(-3));
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadUserActions(int)

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#loadUserActions(int)}
     */
    @Test
    @DisplayName("loadUserActions: loadUserActions: userId = -3 (mutated from -1) -> throw NullPointerException")
    public void testLoadUserActionsThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadUserActions(-3));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteractionRepository.loadUserActionsByAction


    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#loadUserActionsByAction(int, String)}
     */
    @Test
    @DisplayName("loadUserActionsByAction: userId = 16386 (mutated from 2), action = '10' -> throw NullPointerException")
    public void testLoadUserActionsByActionThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadUserActionsByAction(16386, "10"));
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadUserActionsByAction(int, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#loadUserActionsByAction(int, String)}
     */
    @Test
    @DisplayName("loadUserActionsByAction: loadUserActionsByAction: userId = 16386 (mutated from 2), action = '10' -> throw NullPointerException")
    public void testLoadUserActionsByActionThrowsNPEWithNonEmptyString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.loadUserActionsByAction(16386, "10"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteractionRepository.recordUserAction


    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#recordUserAction(int, int, String)}
     */
    @Test
    @DisplayName("recordUserAction: userId = -1 (mutated from max), articleId = 3, action = 'abc' -> throw NullPointerException")
    public void testRecordUserActionThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.recordUserAction(-1, 3, "abc"));
    }

    @Test
    public void testRecordUserAction1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.createStatement())).thenReturn(((Statement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.recordUserAction(-255, -255, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method recordUserAction(int, int, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#recordUserAction(int, int, String)}
     */
    @Test
    @DisplayName("recordUserAction: recordUserAction: userId = -1 (mutated from max), articleId = 3, action = 'abc' -> throw NullPointerException")
    public void testRecordUserActionThrowsNPEWithNonEmptyString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.recordUserAction(-1, 3, "abc"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserArticleInteractionRepository.removeUserAction


    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#removeUserAction(int, int, String)}
     */
    @Test
    @DisplayName("removeUserAction: userId = -1 (mutated from max), articleId = 3, action = '\n\t\r' -> throw NullPointerException")
    public void testRemoveUserActionThrowsNPEWithBlankString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.removeUserAction(-1, 3, "\n\t\r"));
    }

    @Test
    public void testRemoveUserAction1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.createStatement())).thenReturn(((Statement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.removeUserAction(-255, -255, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testRemoveUserAction2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(null);

            assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.removeUserAction(-255, -255, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method removeUserAction(int, int, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserArticleInteractionRepository}
     * @utbot.methodUnderTest {@link UserArticleInteractionRepository#removeUserAction(int, int, String)}
     */
    @Test
    @DisplayName("removeUserAction: removeUserAction: userId = -1 (mutated from max), articleId = 3, action = '\n\t\r' -> throw NullPointerException")
    public void testRemoveUserActionThrowsNPEWithBlankString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserArticleInteractionRepository userArticleInteractionRepository = new UserArticleInteractionRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userArticleInteractionRepository.removeUserAction(-1, 3, "\n\t\r"));
    }
    ///endregion

    ///endregion
}
