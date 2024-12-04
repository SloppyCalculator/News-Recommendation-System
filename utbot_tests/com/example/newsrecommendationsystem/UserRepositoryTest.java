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

public final class UserRepositoryTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.authenticateUser


    @Test
    public void testAuthenticateUser1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            boolean actual = userRepository.authenticateUser(null, null);

            assertFalse(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#authenticateUser(String, String)}
     */
    @Test
    @DisplayName("authenticateUser: username = 'XZ\u008A' (mutated from 'XZ'), password = 'SELECT * F...' -> throw NullPointerException")
    public void testAuthenticateUserThrowsNPEWithNonEmptyStrings() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.authenticateUser("XZ\u008A", "SELECT * FROM users WHERE username = ? AND password = ?"));
    }

    @Test
    public void testAuthenticateUser2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.authenticateUser(null, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testAuthenticateUser3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (when(preparedStatementMock.executeQuery())).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.authenticateUser(null, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testAuthenticateUser4() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.authenticateUser(null, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method authenticateUser(java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#authenticateUser(String, String)}
     */
    @Test
    @DisplayName("authenticateUser: authenticateUser: username = 'XZ\u008A' (mutated from 'XZ'), password = 'SELECT * F...' -> throw NullPointerException")
    public void testAuthenticateUserThrowsNPEWithNonEmptyStrings1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.authenticateUser("XZ\u008A", "SELECT * FROM users WHERE username = ? AND password = ?"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.createUser


    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#createUser(String, String, ArrayList)}
     */
    @Test
    @DisplayName("createUser: username = 'Z', password = 'INSERT INT...', preferences = collection -> throw NullPointerException")
    public void testCreateUserThrowsNPEWithNonEmptyStrings() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);
        ArrayList preferences = new ArrayList();
        preferences.add("10");
        preferences.add("INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)");
        preferences.add("INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)");

        assertThrows(NullPointerException.class, () -> userRepository.createUser("Z", "INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)", preferences));
    }

    @Test
    public void testCreateUser1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.createStatement())).thenReturn(((Statement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.createUser(null, null, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testCreateUser2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.createUser(null, null, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method createUser(java.lang.String, java.lang.String, java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#createUser(String, String, ArrayList)}
     */
    @Test
    @DisplayName("createUser: createUser: username = 'Z', password = 'INSERT INT...', preferences = collection -> throw NullPointerException")
    public void testCreateUserThrowsNPEWithNonEmptyStrings1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);
        ArrayList preferences = new ArrayList();
        preferences.add("10");
        preferences.add("INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)");
        preferences.add("INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)");

        assertThrows(NullPointerException.class, () -> userRepository.createUser("Z", "INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)", preferences));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.deleteUserById


    @Test
    public void testDeleteUserById1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            (when(preparedStatementMock.executeUpdate())).thenReturn(1);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            boolean actual = userRepository.deleteUserById(-255);

            assertTrue(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#deleteUserById(int)}
     */
    @Test
    @DisplayName("deleteUserById: userId = 3 (mutated from positive) -> throw NullPointerException")
    public void testDeleteUserByIdThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.deleteUserById(3));
    }

    @Test
    public void testDeleteUserById2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.deleteUserById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testDeleteUserById3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.deleteUserById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method deleteUserById(int)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#deleteUserById(int)}
     */
    @Test
    @DisplayName("deleteUserById: deleteUserById: userId = 3 (mutated from positive) -> throw NullPointerException")
    public void testDeleteUserByIdThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.deleteUserById(3));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.doesUsernameExist


    @Test
    public void testDoesUsernameExist1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            boolean actual = userRepository.doesUsernameExist(null);

            assertFalse(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#doesUsernameExist(String)}
     */
    @Test
    @DisplayName("doesUsernameExist: username = 'X\u001FZ' (mutated from 'XZ') -> throw NullPointerException")
    public void testDoesUsernameExistThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.doesUsernameExist("X\u001FZ"));
    }

    @Test
    public void testDoesUsernameExist2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.doesUsernameExist(null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testDoesUsernameExist3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.doesUsernameExist(null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testDoesUsernameExist4() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (when(preparedStatementMock.executeQuery())).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.doesUsernameExist(null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method doesUsernameExist(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#doesUsernameExist(String)}
     */
    @Test
    @DisplayName("doesUsernameExist: doesUsernameExist: username = 'X\u001FZ' (mutated from 'XZ') -> throw NullPointerException")
    public void testDoesUsernameExistThrowsNPEWithNonEmptyString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.doesUsernameExist("X\u001FZ"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.loadAllUsers


    @Test
    public void testLoadAllUsers1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (((ResultSet) (doNothing()).when(resultSetMock))).close();
            (when(statementMock.executeQuery(any()))).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            ArrayList actual = ((ArrayList) userRepository.loadAllUsers());

            ArrayList expected = new ArrayList();

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#loadAllUsers()}
     */
    @Test
    @DisplayName("loadAllUsers:  -> throw NullPointerException")
    public void testLoadAllUsersThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.loadAllUsers());
    }

    @Test
    public void testLoadAllUsers2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadAllUsers());
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadAllUsers3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.createStatement())).thenReturn(((Statement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadAllUsers());
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadAllUsers4() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.executeQuery(any()))).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadAllUsers());
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadAllUsers()

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#loadAllUsers()}
     */
    @Test
    @DisplayName("loadAllUsers: loadAllUsers:  -> throw NullPointerException")
    public void testLoadAllUsersThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.loadAllUsers());
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.loadUserById


    @Test
    public void testLoadUserById1() throws SQLException {
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
            UserRepository userRepository = new UserRepository(null);

            User actual = userRepository.loadUserById(-255);

            assertNull(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#loadUserById(int)}
     */
    @Test
    @DisplayName("loadUserById: id = -3 (mutated from -1) -> throw NullPointerException")
    public void testLoadUserByIdThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.loadUserById(-3));
    }

    @Test
    public void testLoadUserById2() throws SQLException {
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
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadUserById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadUserById3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadUserById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadUserById4() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadUserById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadUserById(int)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#loadUserById(int)}
     */
    @Test
    @DisplayName("loadUserById: loadUserById: id = -3 (mutated from -1) -> throw NullPointerException")
    public void testLoadUserByIdThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.loadUserById(-3));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.loadUserByUsername


    @Test
    public void testLoadUserByUsername1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            User actual = userRepository.loadUserByUsername(null);

            assertNull(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#loadUserByUsername(String)}
     */
    @Test
    @DisplayName("loadUserByUsername: username = 'X\u001FZ' (mutated from 'XZ') -> throw NullPointerException")
    public void testLoadUserByUsernameThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.loadUserByUsername("X\u001FZ"));
    }

    @Test
    public void testLoadUserByUsername2() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (when(preparedStatementMock.executeQuery())).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadUserByUsername(null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadUserByUsername3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadUserByUsername(null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testLoadUserByUsername4() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.loadUserByUsername(null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadUserByUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#loadUserByUsername(String)}
     */
    @Test
    @DisplayName("loadUserByUsername: loadUserByUsername: username = 'X\u001FZ' (mutated from 'XZ') -> throw NullPointerException")
    public void testLoadUserByUsernameThrowsNPEWithNonEmptyString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.loadUserByUsername("X\u001FZ"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.saveUserPreferences


    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#saveUserPreferences(int, ArrayList)}
     */
    @Test
    @DisplayName("saveUserPreferences: userId = -16385 (mutated from -1), preferences = null -> throw NullPointerException")
    public void testSaveUserPreferencesThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.saveUserPreferences(-16385, null));
    }

    @Test
    public void testSaveUserPreferences1() {
        UserRepository userRepository = new UserRepository(null);
        ArrayList preferences = new ArrayList();
        preferences.add(null);
        preferences.add(null);
        preferences.add(null);

        assertThrows(NullPointerException.class, () -> userRepository.saveUserPreferences(0, preferences));
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method saveUserPreferences(int, java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#saveUserPreferences(int, ArrayList)}
     */
    @Test
    @DisplayName("saveUserPreferences: saveUserPreferences: userId = -16385 (mutated from -1), preferences = null -> throw NullPointerException")
    public void testSaveUserPreferencesThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.saveUserPreferences(-16385, null));
    }
    ///endregion

    ///region OTHER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method saveUserPreferences(int, java.util.ArrayList)

    @Test
    public void testSaveUserPreferences11() {
        UserRepository userRepository = new UserRepository(null);
        ArrayList preferences = new ArrayList();
        preferences.add(null);
        preferences.add(null);
        preferences.add(null);

        assertThrows(NullPointerException.class, () -> userRepository.saveUserPreferences(0, preferences));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.updatePassword


    @Test
    public void testUpdatePassword1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            (when(preparedStatementMock.executeUpdate())).thenReturn(0);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            boolean actual = userRepository.updatePassword(-255, null);

            assertFalse(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#updatePassword(int, String)}
     */
    @Test
    @DisplayName("updatePassword: userId = -16385 (mutated from -1), newPassword = '10' -> throw NullPointerException")
    public void testUpdatePasswordThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.updatePassword(-16385, "10"));
    }

    @Test
    public void testUpdatePassword2() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.updatePassword(-255, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testUpdatePassword3() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.updatePassword(-255, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method updatePassword(int, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#updatePassword(int, String)}
     */
    @Test
    @DisplayName("updatePassword: updatePassword: userId = -16385 (mutated from -1), newPassword = '10' -> throw NullPointerException")
    public void testUpdatePasswordThrowsNPEWithNonEmptyString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.updatePassword(-16385, "10"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.updatePreferences


    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#updatePreferences(int, ArrayList)}
     */
    @Test
    @DisplayName("updatePreferences: userId = -16385 (mutated from -1), newPreferences = null -> throw NullPointerException")
    public void testUpdatePreferencesThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.updatePreferences(-16385, null));
    }

    @Test
    public void testUpdatePreferences1() {
        UserRepository userRepository = new UserRepository(null);
        ArrayList newPreferences = new ArrayList();
        newPreferences.add(null);
        newPreferences.add(null);
        newPreferences.add(null);

        assertThrows(NullPointerException.class, () -> userRepository.updatePreferences(0, newPreferences));
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method updatePreferences(int, java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#updatePreferences(int, ArrayList)}
     */
    @Test
    @DisplayName("updatePreferences: updatePreferences: userId = -16385 (mutated from -1), newPreferences = null -> throw NullPointerException")
    public void testUpdatePreferencesThrowsNPE1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.updatePreferences(-16385, null));
    }
    ///endregion

    ///region OTHER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method updatePreferences(int, java.util.ArrayList)

    @Test
    public void testUpdatePreferences11() {
        UserRepository userRepository = new UserRepository(null);
        ArrayList newPreferences = new ArrayList();
        newPreferences.add(null);
        newPreferences.add(null);
        newPreferences.add(null);

        assertThrows(NullPointerException.class, () -> userRepository.updatePreferences(0, newPreferences));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.UserRepository.updateUsername


    @Test
    public void testUpdateUsername1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            (when(preparedStatementMock.executeUpdate())).thenReturn(1);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            boolean actual = userRepository.updateUsername(-255, null);

            assertTrue(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#updateUsername(int, String)}
     */
    @Test
    @DisplayName("updateUsername: userId = -16385 (mutated from -1), newUsername = '10' -> throw NullPointerException")
    public void testUpdateUsernameThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.updateUsername(-16385, "10"));
    }

    @Test
    public void testUpdateUsername2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.updateUsername(-255, null));
        } finally {
            mockedStatic.close();
        }
    }

    @Test
    public void testUpdateUsername3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            UserRepository userRepository = new UserRepository(null);

            assertThrows(NullPointerException.class, () -> userRepository.updateUsername(-255, null));
        } finally {
            mockedStatic.close();
        }
    }

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method updateUsername(int, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserRepository}
     * @utbot.methodUnderTest {@link UserRepository#updateUsername(int, String)}
     */
    @Test
    @DisplayName("updateUsername: updateUsername: userId = -16385 (mutated from -1), newUsername = '10' -> throw NullPointerException")
    public void testUpdateUsernameThrowsNPEWithNonEmptyString1() {
        DatabaseManager databaseManager = new DatabaseManager();
        UserRepository userRepository = new UserRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> userRepository.updateUsername(-16385, "10"));
    }
    ///endregion

    ///endregion
}
