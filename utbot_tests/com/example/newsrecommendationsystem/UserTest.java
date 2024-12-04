package com.example.newsrecommendationsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import sun.security.jca.GetInstance;
import sun.security.jca.GetInstance.Instance;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class UserTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.User.addLikedArticle

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addLikedArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#addLikedArticle(Article)}
     * @utbot.invokes {@link ArrayList#contains(Object)}
     * @utbot.throwsException {@link NullPointerException} when: !likedArticles.contains(article)
     */
    @Test
    @DisplayName("addLikedArticle: !likedArticles.contains(article) -> ThrowNullPointerException")
    public void testAddLikedArticle_ThrowNullPointerException() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.User.addLikedArticle] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.User.addLikedArticle(User.java:96) */
        user.addLikedArticle(null);
    }
    ///endregion

    ///region OTHER: SUCCESSFUL EXECUTIONS for method addLikedArticle(com.example.newsrecommendationsystem.Article)

    @Test
    public void testAddLikedArticle1() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList likedArticles = new ArrayList();
        setField(user, "com.example.newsrecommendationsystem.User", "likedArticles", likedArticles);

        user.addLikedArticle(null);
    }

    @Test
    public void testAddLikedArticle2() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList likedArticles = new ArrayList();
        Article article = ((Article) createInstance("com.example.newsrecommendationsystem.Article"));
        likedArticles.add(article);
        likedArticles.add(null);
        likedArticles.add(null);
        setField(user, "com.example.newsrecommendationsystem.User", "likedArticles", likedArticles);

        user.addLikedArticle(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.addPreference

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method addPreference(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#addPreference(String)}
     * @utbot.invokes {@link ArrayList#add(Object)}
     */
    @Test
    @DisplayName("addPreference: -> ArrayListAdd")
    public void testAddPreference_ArrayListAdd() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList preferences = new ArrayList();
        preferences.add(null);
        preferences.add(null);
        preferences.add(null);
        setField(user, "com.example.newsrecommendationsystem.User", "preferences", preferences);

        user.addPreference(null);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addPreference(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#addPreference(String)}
     * @utbot.invokes {@link ArrayList#add(Object)}
     * @utbot.throwsException {@link NullPointerException} in: preferences.add(preference);
     */
    @Test
    @DisplayName("addPreference: preferences.add(preference) : True -> ThrowNullPointerException")
    public void testAddPreference_ThrowNullPointerException() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.User.addPreference] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.User.addPreference(User.java:112) */
        user.addPreference(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.addReadArticle

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addReadArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#addReadArticle(Article)}
     * @utbot.invokes {@link ArrayList#contains(Object)}
     * @utbot.throwsException {@link NullPointerException} when: !readArticles.contains(article)
     */
    @Test
    @DisplayName("addReadArticle: !readArticles.contains(article) -> ThrowNullPointerException")
    public void testAddReadArticle_ThrowNullPointerException() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.User.addReadArticle] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.User.addReadArticle(User.java:90) */
        user.addReadArticle(null);
    }
    ///endregion

    ///region OTHER: SUCCESSFUL EXECUTIONS for method addReadArticle(com.example.newsrecommendationsystem.Article)

    @Test
    public void testAddReadArticle1() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList readArticles = new ArrayList();
        setField(user, "com.example.newsrecommendationsystem.User", "readArticles", readArticles);

        user.addReadArticle(null);
    }

    @Test
    public void testAddReadArticle2() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList readArticles = new ArrayList();
        readArticles.add(null);
        readArticles.add(null);
        readArticles.add(null);
        setField(user, "com.example.newsrecommendationsystem.User", "readArticles", readArticles);

        user.addReadArticle(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.addSkippedArticle

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addSkippedArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#addSkippedArticle(Article)}
     * @utbot.invokes {@link ArrayList#contains(Object)}
     * @utbot.throwsException {@link NullPointerException} when: !skippedArticles.contains(article)
     */
    @Test
    @DisplayName("addSkippedArticle: !skippedArticles.contains(article) -> ThrowNullPointerException")
    public void testAddSkippedArticle_ThrowNullPointerException() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.User.addSkippedArticle] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.User.addSkippedArticle(User.java:102) */
        user.addSkippedArticle(null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method addSkippedArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#addSkippedArticle(Article)}
     */
    @Test
    @DisplayName("addSkippedArticle: article = Article(String, Date, String, String, String, String)")
    public void testAddSkippedArticle() {
        User user = new User("abc", "#$\\\"'", "\n\t\r");
        Date date = new Date(Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
        Article article = new Article("#$\\\"'", date, "", "-3", "abc", "10");
        article.setGuid("");
        article.setDescription("-3");
        article.setId(0);
        article.setTitle("\n\t\r");
        article.setCategory("abc");
        Date date1 = new Date(Integer.MAX_VALUE, -1, 0, -1, 0, 0);
        article.setPubDate(date1);
        article.setLink("10");
        article.setActions("#$\\\"'");

        user.addSkippedArticle(article);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.changePassword

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method changePassword(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#changePassword(String)}
     * @utbot.invokes com.example.newsrecommendationsystem.User#hashPassword(java.lang.String)
     * @utbot.throwsException {@link ClassCastException} in: this.passwordHash = hashPassword(password);
     */
    @Test
    @DisplayName("changePassword: this.passwordHash = hashPassword(password) -> ThrowClassCastException")
    public void testChangePassword_ThrowClassCastException() throws Exception {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(GetInstance.class);
            Instance instance = ((Instance) createInstance("sun.security.jca.GetInstance$Instance"));
            int[] impl = {};
            setField(instance, "sun.security.jca.GetInstance$Instance", "impl", impl);
            (mockedStatic.when(() -> GetInstance.getInstance(any(String.class), any(Class.class), any(String.class)))).thenReturn(instance);
            User user = new User(((String) null), ((String) null), ((String) null));

            /* This test fails because method [com.example.newsrecommendationsystem.User.changePassword] produces [java.lang.ClassCastException: The object with type java.lang.Object can not be casted to java.security.MessageDigestSpi] */
            user.changePassword(null);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method changePassword(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#changePassword(String)}
     */
    @Test
    @DisplayName("changePassword: password = ''")
    public void testChangePasswordWithEmptyString() {
        User user = new User("abc", "#$\\\"'", "\n\t\r");

        user.changePassword("");
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.changeUsername

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method changeUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#changeUsername(String)}
     */
    @Test
    @DisplayName("changeUsername: ")
    public void testChangeUsername() {
        User user = new User(0, null, null, null);

        user.changeUsername(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getLikedArticles

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getLikedArticles()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getLikedArticles()}
     * @utbot.returnsFrom {@code return likedArticles;}
     */
    @Test
    @DisplayName("getLikedArticles: -> return likedArticles")
    public void testGetLikedArticles_ReturnLikedArticles() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));

        ArrayList actual = user.getLikedArticles();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getPassword

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPassword()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getPassword()}
     * @utbot.returnsFrom {@code return passwordHash;}
     */
    @Test
    @DisplayName("getPassword: -> return passwordHash")
    public void testGetPassword_ReturnPasswordHash() {
        User user = new User(0, null, null, null);

        String actual = user.getPassword();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getPreferences

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPreferences()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getPreferences()}
     * @utbot.returnsFrom {@code return preferences;}
     */
    @Test
    @DisplayName("getPreferences: -> return preferences")
    public void testGetPreferences_ReturnPreferences() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));

        ArrayList actual = user.getPreferences();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getReadArticles

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getReadArticles()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getReadArticles()}
     * @utbot.returnsFrom {@code return readArticles;}
     */
    @Test
    @DisplayName("getReadArticles: -> return readArticles")
    public void testGetReadArticles_ReturnReadArticles() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));

        ArrayList actual = user.getReadArticles();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getSkippedArticles

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getSkippedArticles()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getSkippedArticles()}
     * @utbot.returnsFrom {@code return skippedArticles;}
     */
    @Test
    @DisplayName("getSkippedArticles: -> return skippedArticles")
    public void testGetSkippedArticles_ReturnSkippedArticles() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));

        ArrayList actual = user.getSkippedArticles();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getUserID

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getUserID()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getUserID()}
     * @utbot.returnsFrom {@code return userID;}
     */
    @Test
    @DisplayName("getUserID: -> return userID")
    public void testGetUserID_ReturnUserID() {
        User user = new User(-255, null, null, null);

        int actual = user.getUserID();

        assertEquals(-255, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.getUsername

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getUsername()

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#getUsername()}
     * @utbot.returnsFrom {@code return username;}
     */
    @Test
    @DisplayName("getUsername: -> return username")
    public void testGetUsername_ReturnUsername() {
        User user = new User(0, null, null, null);

        String actual = user.getUsername();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.removeLikedArticle

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method removeLikedArticle(com.example.newsrecommendationsystem.Article)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#removeLikedArticle(Article)}
     * @utbot.invokes {@link ArrayList#remove(Object)}
     * @utbot.throwsException {@link NullPointerException} in: likedArticles.remove(article);
     */
    @Test
    @DisplayName("removeLikedArticle: likedArticles.remove(article) : True -> ThrowNullPointerException")
    public void testRemoveLikedArticle_ThrowNullPointerException() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.User.removeLikedArticle] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.User.removeLikedArticle(User.java:108) */
        user.removeLikedArticle(null);
    }
    ///endregion

    ///region OTHER: SUCCESSFUL EXECUTIONS for method removeLikedArticle(com.example.newsrecommendationsystem.Article)

    @Test
    public void testRemoveLikedArticle1() throws Exception {
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList likedArticles = new ArrayList();
        setField(user, "com.example.newsrecommendationsystem.User", "likedArticles", likedArticles);

        user.removeLikedArticle(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.toString

    ///region OTHER: SUCCESSFUL EXECUTIONS for method toString()

    @Test
    public void testToString1() {
        User user = new User(Integer.MIN_VALUE, null, null, null);

        String actual = user.toString();

        String expected = "User{userID='-2147483648', username='null'}";

        assertEquals(expected, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.User.verifyPassword

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method verifyPassword(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#verifyPassword(String)}
     * @utbot.invokes com.example.newsrecommendationsystem.User#hashPassword(java.lang.String)
     * @utbot.throwsException {@link ClassCastException} in: String hashedInput = hashPassword(password);
     */
    @Test
    @DisplayName("verifyPassword: hashedInput = hashPassword(password) : True -> ThrowClassCastException")
    public void testVerifyPassword_ThrowClassCastException() throws Exception {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(GetInstance.class);
            Instance instance = ((Instance) createInstance("sun.security.jca.GetInstance$Instance"));
            int[] impl = {};
            setField(instance, "sun.security.jca.GetInstance$Instance", "impl", impl);
            (mockedStatic.when(() -> GetInstance.getInstance(any(String.class), any(Class.class), any(String.class)))).thenReturn(instance);
            User user = new User(((String) null), ((String) null), ((String) null));

            /* This test fails because method [com.example.newsrecommendationsystem.User.verifyPassword] produces [java.lang.ClassCastException: The object with type java.lang.Object can not be casted to java.security.MessageDigestSpi] */
            user.verifyPassword(null);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method verifyPassword(java.lang.String)

    /**
     * @utbot.classUnderTest {@link User}
     * @utbot.methodUnderTest {@link User#verifyPassword(String)}
     */
    @Test
    @DisplayName("verifyPassword: password = '' -> return false")
    public void testVerifyPasswordReturnsFalseWithEmptyString() {
        User user = new User("abc", "#$\\\"'", "\n\t\r");

        boolean actual = user.verifyPassword("");

        assertFalse(actual);
    }
    ///endregion

    ///endregion
}
