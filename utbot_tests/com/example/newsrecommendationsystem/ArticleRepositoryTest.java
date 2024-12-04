package com.example.newsrecommendationsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.Context;
import org.mockito.MockedStatic;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.utbot.runtime.utils.java.UtUtils.deepEquals;

public final class ArticleRepositoryTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.addArticle

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method addArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#addArticle(Article)}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("addArticle: return false : True -> ThrowNullPointerException")
    public void testAddArticle_ThrowNullPointerException() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.execute(any()))).thenReturn(false);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock, ((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.addArticle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#addArticle(Article)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("addArticle: return false : True -> ThrowNullPointerException")
    public void testAddArticle_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.execute(any()))).thenReturn(false);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock, connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.addArticle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#addArticle(Article)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("addArticle: return false : True -> ThrowNullPointerException")
    public void testAddArticle_ThrowNullPointerException_3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.execute(any()))).thenReturn(false);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock, connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.addArticle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#addArticle(Article)}
     * @utbot.invokes {@link PreparedStatement#setString(int, String)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("addArticle: return false : True -> ThrowNullPointerException")
    public void testAddArticle_ThrowNullPointerException_2() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.execute(any()))).thenReturn(false);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock, connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);
            Article article = new Article(0, null, null, null, null, null, null);

            assertThrows(NullPointerException.class, () -> articleRepository.addArticle(article));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#addArticle(Article)}
     * @utbot.invokes {@link Article#getPubDate()}
     * @utbot.invokes {@link java.util.Date#getTime()}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("addArticle: return false : True -> ThrowNullPointerException")
    public void testAddArticle_ThrowNullPointerException_4() throws SQLException {
        MockedConstruction mockedConstruction = null;
        MockedStatic mockedStatic = null;
        try {
            mockedConstruction = mockConstruction(Date.class, (Date dateMock, Context context) -> {
            });
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.execute(any()))).thenReturn(false);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock, connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);
            Article article = new Article(0, null, null, null, null, null, null);

            assertThrows(NullPointerException.class, () -> articleRepository.addArticle(article));
        } finally {
            mockedConstruction.close();
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method addArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#addArticle(Article)}
     */
    @Test
    @DisplayName("addArticle: article = Article(String, Date, String, String, String, String) -> throw NullPointerException")
    public void testAddArticleThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);
        java.util.Date date = new java.util.Date(-1, Integer.MAX_VALUE, 1, 0, 5);
        Article article = new Article("\n\t\r", date, "INSERT INTO articles (title, pubDate, guid, link, description, category) VALUES (?, ?, ?, ?, ?, ?)", "", "abc", "INSERT INTO articles (title, pubDate, guid, link, description, category) VALUES (?, ?, ?, ?, ?, ?)");
        article.setGuid("#$\\\"'");
        article.setActions("abc");
        java.util.Date date1 = new java.util.Date(Integer.MAX_VALUE, 1, 6, 2, 0);
        article.setPubDate(date1);
        article.setTitle("INSERT INTO articles (titDle, pubDate, guid, link, description, category) VALUES (?, ?, ?, ?, ?, ?)");
        article.setLink("XZ");
        article.setCategory("-3");
        article.setDescription("10");
        article.setId(-1);

        assertThrows(NullPointerException.class, () -> articleRepository.addArticle(article));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.createArticleTable

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method createArticleTable()

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#createArticleTable()}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * throw new RuntimeException(e);
     * }): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * throw new RuntimeException(e);
     * }): True}
     * @utbot.invokes {@link DatabaseManager#connect()}
     * @utbot.invokes {@link Statement#execute(String)}
     * @utbot.invokes {@link java.io.PrintStream#println(String)}
     * @utbot.invokes {@link Statement#close()}
     * @utbot.invokes {@link Connection#close()}
     */
    @Test
    @DisplayName("createArticleTable: DatabaseManagerConnect -> ConnectionClose")
    public void testCreateArticleTable_SQLException() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);
            (when(statementMock.execute(any()))).thenReturn(false);
            (((Statement) (doNothing()).when(statementMock))).close();
            (when(connectionMock.createStatement())).thenReturn(statementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);

            ArticleRepository.createArticleTable();
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method createArticleTable()

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#createArticleTable()}
     * @utbot.executesCondition {@code (try (Connection conn = dbManager.connect();
     * Statement stmt = conn.createStatement()) {
     * stmt.execute(createTableSQL);
     * System.out.println("Table created or already exists.");
     * } catch (SQLException e) {
     * throw new RuntimeException(e);
     * }): False}
     * @utbot.invokes {@link Connection#createStatement()}
     * @utbot.throwsException {@link NullPointerException} in:  catch (SQLException e) {
     * throw new RuntimeException(e);
     * }
     */
    @Test
    @DisplayName("createArticleTable:  catch (SQLException e) { throw new RuntimeException(e) } -> ThrowNullPointerException")
    public void testCreateArticleTable_ThrowNullPointerException() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));

            assertThrows(NullPointerException.class, () -> ArticleRepository.createArticleTable());
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#createArticleTable()}
     * @utbot.executesCondition {@code (try (Connection conn = dbManager.connect();
     * Statement stmt = conn.createStatement()) {
     * stmt.execute(createTableSQL);
     * System.out.println("Table created or already exists.");
     * } catch (SQLException e) {
     * throw new RuntimeException(e);
     * }): False}
     * @utbot.executesCondition {@code (try (Connection conn = dbManager.connect();
     * Statement stmt = conn.createStatement()) {
     * stmt.execute(createTableSQL);
     * System.out.println("Table created or already exists.");
     * } catch (SQLException e) {
     * throw new RuntimeException(e);
     * }): True}
     * @utbot.invokes {@link Statement#execute(String)}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.throwsException {@link NullPointerException} in:  catch (SQLException e) {
     * throw new RuntimeException(e);
     * }
     */
    @Test
    @DisplayName("createArticleTable:  catch (SQLException e) { throw new RuntimeException(e) } -> ThrowNullPointerException")
    public void testCreateArticleTable_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.createStatement())).thenReturn(((Statement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);

            assertThrows(NullPointerException.class, () -> ArticleRepository.createArticleTable());
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method createArticleTable()

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#createArticleTable()}
     */
    @Test
    @DisplayName("createArticleTable:  -> throw NullPointerException")
    public void testCreateArticleTableThrowsNPE() {
        assertThrows(NullPointerException.class, () -> ArticleRepository.createArticleTable());
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.deleteArticle

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method deleteArticle(int)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#deleteArticle(int)}
     * @utbot.invokes {@link DatabaseManager#connect()}
     * @utbot.invokes {@link PreparedStatement#setInt(int, int)}
     * @utbot.invokes {@link PreparedStatement#executeUpdate()}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.returnsFrom {@code return statement.executeUpdate() > 0;}
     */
    @Test
    @DisplayName("deleteArticle: DatabaseManagerConnect -> return statement.executeUpdate() > 0")
    public void testDeleteArticle_SQLException() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            boolean actual = articleRepository.deleteArticle(-255);

            assertTrue(actual);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method deleteArticle(int)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#deleteArticle(int)}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("deleteArticle: return false : True -> ThrowNullPointerException")
    public void testDeleteArticle_ThrowNullPointerException() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.deleteArticle(-255));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#deleteArticle(int)}
     * @utbot.invokes {@link PreparedStatement#setInt(int, int)}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("deleteArticle: return false : True -> ThrowNullPointerException")
    public void testDeleteArticle_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.deleteArticle(-255));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method deleteArticle(int)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#deleteArticle(int)}
     */
    @Test
    @DisplayName("deleteArticle: id = 3 (mutated from positive) -> throw NullPointerException")
    public void testDeleteArticleThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> articleRepository.deleteArticle(3));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.getAllArticles

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getAllArticles()

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getAllArticles()}
     * @utbot.returnsFrom {@code return articles;}
     */
    @Test
    @DisplayName("getAllArticles: -> return articles")
    public void testGetAllArticles_ReturnArticles() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(false);
            (((ResultSet) (doNothing()).when(resultSetMock))).close();
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            ArrayList actual = articleRepository.getAllArticles();

            ArrayList expected = new ArrayList();

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getAllArticles()}
     * @utbot.iterates iterate the loop {@code while(resultSet.next())} once
     * @utbot.returnsFrom {@code return articles;}
     */
    @Test
    @DisplayName("getAllArticles: while(resultSet.next()) -> return articles")
    public void testGetAllArticles_ResultSetNext() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(true, false);
            (when(resultSetMock.getInt(any(String.class)))).thenReturn(0);
            (when(resultSetMock.getString(any(String.class)))).thenReturn(((String) null), ((String) null), ((String) null), ((String) null), ((String) null));
            (when(resultSetMock.getDate(any(String.class)))).thenReturn(((Date) null));
            (((ResultSet) (doNothing()).when(resultSetMock))).close();
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            ArrayList actual = articleRepository.getAllArticles();

            ArrayList expected = new ArrayList();
            Article article = new Article(0, null, null, null, null, null, null);
            expected.add(article);

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getAllArticles()

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getAllArticles()}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query);
     * ResultSet resultSet = statement.executeQuery()) {
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): False}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.throwsException {@link NullPointerException} in: return articles;
     */
    @Test
    @DisplayName("getAllArticles: return articles : True -> ThrowNullPointerException")
    public void testGetAllArticles_ThrowNullPointerException() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getAllArticles());
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getAllArticles()}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query);
     * ResultSet resultSet = statement.executeQuery()) {
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): False}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query);
     * ResultSet resultSet = statement.executeQuery()) {
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link PreparedStatement#executeQuery()}
     * @utbot.throwsException {@link NullPointerException} in: return articles;
     */
    @Test
    @DisplayName("getAllArticles: return articles : True -> ThrowNullPointerException")
    public void testGetAllArticles_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getAllArticles());
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getAllArticles()}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query);
     * ResultSet resultSet = statement.executeQuery()) {
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): False}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query);
     * ResultSet resultSet = statement.executeQuery()) {
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query);
     * ResultSet resultSet = statement.executeQuery()) {
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link PreparedStatement#executeQuery()}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.throwsException {@link NullPointerException} in: return articles;
     */
    @Test
    @DisplayName("getAllArticles: return articles : True -> ThrowNullPointerException")
    public void testGetAllArticles_ThrowNullPointerException_2() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (when(preparedStatementMock.executeQuery())).thenReturn(((ResultSet) null));
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getAllArticles());
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getAllArticles()

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getAllArticles()}
     */
    @Test
    @DisplayName("getAllArticles:  -> throw NullPointerException")
    public void testGetAllArticlesThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> articleRepository.getAllArticles());
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.getArticleById

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getArticleById(int)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleById(int)}
     * @utbot.executesCondition {@code (resultSet.next()): False}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.returnsFrom {@code return null;}
     */
    @Test
    @DisplayName("getArticleById: resultSet.next() : False -> return null")
    public void testGetArticleById_SQLException() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            Article actual = articleRepository.getArticleById(-255);

            assertNull(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleById(int)}
     * @utbot.executesCondition {@code (resultSet.next()): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link ResultSet#getInt(String)}
     * @utbot.invokes {@link ResultSet#getString(String)}
     * @utbot.invokes {@link ResultSet#getDate(String)}
     * @utbot.invokes {@link ResultSet#getString(String)}
     * @utbot.invokes {@link ResultSet#getString(String)}
     * @utbot.invokes {@link ResultSet#getString(String)}
     * @utbot.invokes {@link ResultSet#getString(String)}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.returnsFrom {@code return new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));}
     */
    @Test
    @DisplayName("getArticleById: resultSet.next() : True -> return new Article(resultSet.getInt(\"id\"), resultSet.getString(\"title\"), resultSet.getDate(\"pubDate\"), resultSet.getString(\"guid\"), resultSet.getString(\"link\"), resultSet.getString(\"description\"), resultSet.getString(\"category\"))")
    public void testGetArticleById_SQLException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setInt(anyInt(), anyInt());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(true);
            (when(resultSetMock.getInt(any(String.class)))).thenReturn(0);
            (when(resultSetMock.getString(any(String.class)))).thenReturn(((String) null), ((String) null), ((String) null), ((String) null), ((String) null));
            (when(resultSetMock.getDate(any(String.class)))).thenReturn(((Date) null));
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            Article actual = articleRepository.getArticleById(-255);

            Article expected = new Article(0, null, null, null, null, null, null);

            int expectedId = expected.getId();
            int actualId = actual.getId();
            assertEquals(expectedId, actualId);

            String actualTitle = actual.getTitle();
            assertNull(actualTitle);

            java.util.Date actualPubDate = actual.getPubDate();
            assertNull(actualPubDate);

            String actualGuid = actual.getGuid();
            assertNull(actualGuid);

            String actualLink = actual.getLink();
            assertNull(actualLink);

            String actualDescription = actual.getDescription();
            assertNull(actualDescription);

            String actualCategory = actual.getCategory();
            assertNull(actualCategory);

        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticleById(int)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleById(int)}
     * @utbot.invokes {@link PreparedStatement#setInt(int, int)}
     * @utbot.invokes {@link PreparedStatement#executeQuery()}
     * @utbot.invokes {@link ResultSet#next()}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.throwsException {@link NullPointerException} in: return null;
     */
    @Test
    @DisplayName("getArticleById: return null -> ThrowNullPointerException")
    public void testGetArticleById_ThrowNullPointerException() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticleById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleById(int)}
     * @utbot.invokes {@link PreparedStatement#setInt(int, int)}
     * @utbot.throwsException {@link NullPointerException} in: return null;
     */
    @Test
    @DisplayName("getArticleById: return null -> ThrowNullPointerException")
    public void testGetArticleById_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticleById(-255));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleById(int)}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.throwsException {@link NullPointerException} in: return null;
     */
    @Test
    @DisplayName("getArticleById: return null -> ThrowNullPointerException")
    public void testGetArticleById_ThrowNullPointerException_2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticleById(-255));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticleById(int)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleById(int)}
     */
    @Test
    @DisplayName("getArticleById: id = -3 (mutated from -1) -> throw NullPointerException")
    public void testGetArticleByIdThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> articleRepository.getArticleById(-3));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.getArticleLinkByTitle

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getArticleLinkByTitle(java.lang.String)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleLinkByTitle(String)}
     * @utbot.executesCondition {@code (resultSet.next()): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link ResultSet#getString(String)}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.returnsFrom {@code return resultSet.getString("link");}
     */
    @Test
    @DisplayName("getArticleLinkByTitle: resultSet.next() : True -> return resultSet.getString(\"link\")")
    public void testGetArticleLinkByTitle_SQLException() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(true);
            (when(resultSetMock.getString(any(String.class)))).thenReturn(((String) null));
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            String actual = articleRepository.getArticleLinkByTitle(null);

            assertNull(actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleLinkByTitle(String)}
     * @utbot.executesCondition {@code (resultSet.next()): False}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.executesCondition {@code ( catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.invokes {@link Connection#close()}
     * @utbot.returnsFrom {@code return null;}
     */
    @Test
    @DisplayName("getArticleLinkByTitle: resultSet.next() : False -> return null")
    public void testGetArticleLinkByTitle_SQLException_1() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            String actual = articleRepository.getArticleLinkByTitle(null);

            assertNull(actual);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticleLinkByTitle(java.lang.String)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleLinkByTitle(String)}
     * @utbot.invokes {@link PreparedStatement#setString(int, String)}
     * @utbot.invokes {@link PreparedStatement#executeQuery()}
     * @utbot.invokes {@link ResultSet#next()}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.throwsException {@link NullPointerException} in: return null;
     */
    @Test
    @DisplayName("getArticleLinkByTitle: return null -> ThrowNullPointerException")
    public void testGetArticleLinkByTitle_ThrowNullPointerException() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticleLinkByTitle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleLinkByTitle(String)}
     * @utbot.invokes {@link PreparedStatement#setString(int, String)}
     * @utbot.throwsException {@link NullPointerException} in: return null;
     */
    @Test
    @DisplayName("getArticleLinkByTitle: return null -> ThrowNullPointerException")
    public void testGetArticleLinkByTitle_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticleLinkByTitle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleLinkByTitle(String)}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.throwsException {@link NullPointerException} in: return null;
     */
    @Test
    @DisplayName("getArticleLinkByTitle: return null -> ThrowNullPointerException")
    public void testGetArticleLinkByTitle_ThrowNullPointerException_2() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticleLinkByTitle(null));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticleLinkByTitle(java.lang.String)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticleLinkByTitle(String)}
     */
    @Test
    @DisplayName("getArticleLinkByTitle: title = '1\uFFF80' (mutated from '10') -> throw NullPointerException")
    public void testGetArticleLinkByTitleThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> articleRepository.getArticleLinkByTitle("1\uFFF80"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.getArticlesByCategory

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getArticlesByCategory(java.lang.String)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategory(String)}
     * @utbot.returnsFrom {@code return articles;}
     */
    @Test
    @DisplayName("getArticlesByCategory: -> return articles")
    public void testGetArticlesByCategory_ReturnArticles() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            ArrayList actual = ((ArrayList) articleRepository.getArticlesByCategory(null));

            ArrayList expected = new ArrayList();

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategory(String)}
     * @utbot.iterates iterate the loop {@code while(resultSet.next())} once
     * @utbot.returnsFrom {@code return articles;}
     */
    @Test
    @DisplayName("getArticlesByCategory: while(resultSet.next()) -> return articles")
    public void testGetArticlesByCategory_ResultSetNext() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            ResultSet resultSetMock = mock(ResultSet.class);
            (when(resultSetMock.next())).thenReturn(true, false);
            (when(resultSetMock.getInt(any(String.class)))).thenReturn(0);
            (when(resultSetMock.getString(any(String.class)))).thenReturn(((String) null), ((String) null), ((String) null), ((String) null), ((String) null));
            (when(resultSetMock.getDate(any(String.class)))).thenReturn(((Date) null));
            (when(preparedStatementMock.executeQuery())).thenReturn(resultSetMock);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            ArrayList actual = ((ArrayList) articleRepository.getArticlesByCategory(null));

            ArrayList expected = new ArrayList();
            Article article = new Article(0, null, null, null, null, null, null);
            expected.add(article);

            assertTrue(deepEquals(expected, actual));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticlesByCategory(java.lang.String)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategory(String)}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query)) {
     * statement.setString(1, category);
     * ResultSet resultSet = statement.executeQuery();
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): False}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.throwsException {@link NullPointerException} in: return articles;
     */
    @Test
    @DisplayName("getArticlesByCategory: return articles : True -> ThrowNullPointerException")
    public void testGetArticlesByCategory_ThrowNullPointerException() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticlesByCategory(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategory(String)}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query)) {
     * statement.setString(1, category);
     * ResultSet resultSet = statement.executeQuery();
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): False}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query)) {
     * statement.setString(1, category);
     * ResultSet resultSet = statement.executeQuery();
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link PreparedStatement#setString(int, String)}
     * @utbot.throwsException {@link NullPointerException} in: return articles;
     */
    @Test
    @DisplayName("getArticlesByCategory: return articles : True -> ThrowNullPointerException")
    public void testGetArticlesByCategory_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticlesByCategory(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategory(String)}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query)) {
     * statement.setString(1, category);
     * ResultSet resultSet = statement.executeQuery();
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.executesCondition {@code (try (Connection connection = dbManager.connect();
     * PreparedStatement statement = connection.prepareStatement(query)) {
     * statement.setString(1, category);
     * ResultSet resultSet = statement.executeQuery();
     * while (resultSet.next()) {
     * Article article = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("pubDate"), resultSet.getString("guid"), resultSet.getString("link"), resultSet.getString("description"), resultSet.getString("category"));
     * articles.add(article);
     * }
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }): True}
     * @utbot.invokes {@link PreparedStatement#setString(int, String)}
     * @utbot.invokes {@link PreparedStatement#executeQuery()}
     * @utbot.invokes {@link PreparedStatement#close()}
     * @utbot.throwsException {@link NullPointerException} in: return articles;
     */
    @Test
    @DisplayName("getArticlesByCategory: return articles : True -> ThrowNullPointerException")
    public void testGetArticlesByCategory_ThrowNullPointerException_2() throws SQLException {
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
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.getArticlesByCategory(null));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticlesByCategory(java.lang.String)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategory(String)}
     */
    @Test
    @DisplayName("getArticlesByCategory: category = '1\uFFF80' (mutated from '10') -> throw NullPointerException")
    public void testGetArticlesByCategoryThrowsNPEWithNonEmptyString() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);

        assertThrows(NullPointerException.class, () -> articleRepository.getArticlesByCategory("1\uFFF80"));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.getArticlesByCategoryPreferences

    ///region FUZZER: ERROR SUITE for method getArticlesByCategoryPreferences(java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByCategoryPreferences(ArrayList)}
     */
    @Test
    @DisplayName("getArticlesByCategoryPreferences: categories = null -> throw NullPointerException")
    public void testGetArticlesByCategoryPreferencesThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);
        
        /* This test fails because method [com.example.newsrecommendationsystem.ArticleRepository.getArticlesByCategoryPreferences] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.ArticleRepository.getArticlesByCategoryPreferences(ArticleRepository.java:198) */
        articleRepository.getArticlesByCategoryPreferences(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.getArticlesByIds

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getArticlesByIds(java.util.List)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByIds(java.util.List)}
     * @utbot.executesCondition {@code (ids == null): True}
     */
    @Test
    @DisplayName("getArticlesByIds: ids == null : False -> return articles")
    public void testGetArticlesByIds_IdsEqualsNull() {
        ArticleRepository articleRepository = new ArticleRepository(null);

        ArrayList actual = ((ArrayList) articleRepository.getArticlesByIds(null));

        ArrayList expected = new ArrayList();

        assertTrue(deepEquals(expected, actual));
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#getArticlesByIds(java.util.List)}
     * @utbot.executesCondition {@code (ids == null): False}
     * @utbot.executesCondition {@code (ids.isEmpty()): True}
     * @utbot.invokes {@link java.util.List#isEmpty()}
     */
    @Test
    @DisplayName("getArticlesByIds: ids == null : True -> return articles")
    public void testGetArticlesByIds_IdsIsEmpty() {
        ArticleRepository articleRepository = new ArticleRepository(null);
        ArrayList ids = new ArrayList();

        ArrayList actual = ((ArrayList) articleRepository.getArticlesByIds(ids));

        ArrayList expected = new ArrayList();

        assertTrue(deepEquals(expected, actual));
    }
    ///endregion

    ///region OTHER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method getArticlesByIds(java.util.List)

    @Test
    public void testGetArticlesByIds1() {
        ArticleRepository articleRepository = new ArticleRepository(null);
        ArrayList ids = new ArrayList();
        ids.add(null);
        ids.add(null);
        ids.add(null);
        ids.add(null);

        assertThrows(NullPointerException.class, () -> articleRepository.getArticlesByIds(ids));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.ArticleRepository.updateArticle

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method updateArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#updateArticle(Article)}
     * @utbot.invokes {@link Connection#prepareStatement(String)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("updateArticle: return false : True -> ThrowNullPointerException")
    public void testUpdateArticle_ThrowNullPointerException() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(((Connection) null));
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.updateArticle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#updateArticle(Article)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("updateArticle: return false : True -> ThrowNullPointerException")
    public void testUpdateArticle_ThrowNullPointerException_1() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.updateArticle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#updateArticle(Article)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("updateArticle: return false : True -> ThrowNullPointerException")
    public void testUpdateArticle_ThrowNullPointerException_2() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);

            assertThrows(NullPointerException.class, () -> articleRepository.updateArticle(null));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#updateArticle(Article)}
     * @utbot.invokes {@link PreparedStatement#setString(int, String)}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("updateArticle: return false : True -> ThrowNullPointerException")
    public void testUpdateArticle_ThrowNullPointerException_3() throws SQLException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.prepareStatement(any()))).thenReturn(((PreparedStatement) null));
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);
            Article article = new Article(0, null, null, null, null, null, null);

            assertThrows(NullPointerException.class, () -> articleRepository.updateArticle(article));
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#updateArticle(Article)}
     * @utbot.invokes {@link Article#getPubDate()}
     * @utbot.invokes {@link java.util.Date#getTime()}
     * @utbot.caughtException {@code SQLException e}
     * @utbot.throwsException {@link NullPointerException} in: return false;
     */
    @Test
    @DisplayName("updateArticle: return false : True -> ThrowNullPointerException")
    public void testUpdateArticle_ThrowNullPointerException_4() throws SQLException {
        MockedConstruction mockedConstruction = null;
        MockedStatic mockedStatic = null;
        try {
            mockedConstruction = mockConstruction(Date.class, (Date dateMock, Context context) -> {
            });
            mockedStatic = mockStatic(DriverManager.class);
            Connection connectionMock = mock(Connection.class);
            PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
            (((PreparedStatement) (doNothing()).when(preparedStatementMock))).setString(anyInt(), any());
            (((Statement) (doNothing()).when(preparedStatementMock))).close();
            (when(connectionMock.prepareStatement(any()))).thenReturn(preparedStatementMock);
            (((Connection) (doNothing()).when(connectionMock))).close();
            (mockedStatic.when(() -> DriverManager.getConnection(any()))).thenReturn(connectionMock);
            ArticleRepository articleRepository = new ArticleRepository(null);
            Article article = new Article(0, null, null, null, null, null, null);

            assertThrows(NullPointerException.class, () -> articleRepository.updateArticle(article));
        } finally {
            mockedConstruction.close();
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method updateArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link ArticleRepository}
     * @utbot.methodUnderTest {@link ArticleRepository#updateArticle(Article)}
     */
    @Test
    @DisplayName("updateArticle: article = Article(String, Date, String, String, String, String) -> throw NullPointerException")
    public void testUpdateArticleThrowsNPE() {
        DatabaseManager databaseManager = new DatabaseManager();
        ArticleRepository articleRepository = new ArticleRepository(databaseManager);
        java.util.Date date = new java.util.Date(0, 5, 4, 2, Integer.MAX_VALUE);
        Article article = new Article("\n\t\r", date, "UPDATE articles SET title = ?, pubDate = ?, guid = ?, link = ?, description = ?, category = ? WHERE id = ?", "", "abc", "UPDATE articles SET title = ?, pubDate = ?, guid = ?, link = ?, description = ?, category = ? WHERE id = ?");
        article.setGuid("#$\\\"'");
        article.setActions("abc");
        java.util.Date date1 = new java.util.Date(-1, 6, Integer.MAX_VALUE, 2, Integer.MIN_VALUE);
        article.setPubDate(date1);
        article.setTitle("UPDATE articles\u0018 SET title = ?, pubDate = ?, guid = ?, link = ?, description = ?, category = ? WHERE id = ?");
        article.setLink("XZ");
        article.setCategory("-3");
        article.setDescription("10");
        article.setId(6);

        assertThrows(NullPointerException.class, () -> articleRepository.updateArticle(article));
    }
    ///endregion

    ///endregion
}
