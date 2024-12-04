package com.example.newsrecommendationsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import sun.security.jca.GetInstance;
import sun.security.jca.GetInstance.Instance;
import sun.security.rsa.SunRsaSign;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class AdminTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.deleteUser

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method deleteUser(com.example.newsrecommendationsystem.User, java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#deleteUser(User, ArrayList)}
     * @utbot.invokes {@link ArrayList#remove(Object)}
     */
    @Test
    @DisplayName("deleteUser: -> ArrayListRemove")
    public void testDeleteUser_ArrayListRemove() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        User user = new User(((String) null), ((String) null), ((String) null));
        ArrayList userList = new ArrayList();

        admin.deleteUser(user, userList);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method deleteUser(com.example.newsrecommendationsystem.User, java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#deleteUser(User, ArrayList)}
     * @utbot.invokes {@link ArrayList#remove(Object)}
     * @utbot.throwsException {@link NullPointerException} in: userList.remove(user);
     */
    @Test
    @DisplayName("deleteUser: userList.remove(user) : True -> ThrowNullPointerException")
    public void testDeleteUser_ThrowNullPointerException() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.Admin.deleteUser] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.Admin.deleteUser(Admin.java:40) */
        admin.deleteUser(null, null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.getPassword

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPassword()

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#getPassword()}
     * @utbot.returnsFrom {@code return password;}
     */
    @Test
    @DisplayName("getPassword: -> return password")
    public void testGetPassword_ReturnPassword() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));

        String actual = admin.getPassword();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.getUsername

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getUsername()

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#getUsername()}
     * @utbot.returnsFrom {@code return username;}
     */
    @Test
    @DisplayName("getUsername: -> return username")
    public void testGetUsername_ReturnUsername() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));

        String actual = admin.getUsername();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.Login

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method Login(java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#Login(String, String)}
     */
    @Test
    @DisplayName("Login: ")
    public void testLogin() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));

        admin.Login(null, null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.resetUserPreferences

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method resetUserPreferences(com.example.newsrecommendationsystem.User)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#resetUserPreferences(User)}
     * @utbot.invokes {@link User#getReadArticles()}
     * @utbot.invokes {@link ArrayList#clear()}
     * @utbot.invokes {@link User#getLikedArticles()}
     * @utbot.invokes {@link ArrayList#clear()}
     * @utbot.invokes {@link User#getSkippedArticles()}
     * @utbot.invokes {@link ArrayList#clear()}
     */
    @Test
    @DisplayName("resetUserPreferences: UserGetReadArticles -> ArrayListClear")
    public void testResetUserPreferences_ArrayListClear() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList readArticles = new ArrayList();
        readArticles.add(null);
        readArticles.add(null);
        readArticles.add(null);
        setField(user, "com.example.newsrecommendationsystem.User", "readArticles", readArticles);
        setField(user, "com.example.newsrecommendationsystem.User", "likedArticles", readArticles);
        setField(user, "com.example.newsrecommendationsystem.User", "skippedArticles", readArticles);

        admin.resetUserPreferences(user);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method resetUserPreferences(com.example.newsrecommendationsystem.User)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#resetUserPreferences(User)}
     * @utbot.invokes {@link User#getReadArticles()}
     * @utbot.throwsException {@link NullPointerException} in: user.getReadArticles().clear();
     */
    @Test
    @DisplayName("resetUserPreferences: user.getReadArticles().clear() : True -> ThrowNullPointerException")
    public void testResetUserPreferences_ThrowNullPointerException() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.Admin.resetUserPreferences] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.Admin.resetUserPreferences(Admin.java:44) */
        admin.resetUserPreferences(null);
    }

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#resetUserPreferences(User)}
     * @utbot.throwsException {@link NullPointerException} in: user.getReadArticles().clear();
     */
    @Test
    @DisplayName("resetUserPreferences: user.getReadArticles().clear() : True -> ThrowNullPointerException")
    public void testResetUserPreferences_ThrowNullPointerException_1() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        
        /* This test fails because method [com.example.newsrecommendationsystem.Admin.resetUserPreferences] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.Admin.resetUserPreferences(Admin.java:44) */
        admin.resetUserPreferences(user);
    }

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#resetUserPreferences(User)}
     * @utbot.throwsException {@link NullPointerException} in: user.getLikedArticles().clear();
     */
    @Test
    @DisplayName("resetUserPreferences: user.getLikedArticles().clear() : True -> ThrowNullPointerException")
    public void testResetUserPreferences_ThrowNullPointerException_2() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList readArticles = new ArrayList();
        readArticles.add(null);
        readArticles.add(null);
        readArticles.add(null);
        setField(user, "com.example.newsrecommendationsystem.User", "readArticles", readArticles);
        
        /* This test fails because method [com.example.newsrecommendationsystem.Admin.resetUserPreferences] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.Admin.resetUserPreferences(Admin.java:45) */
        admin.resetUserPreferences(user);
    }

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#resetUserPreferences(User)}
     * @utbot.invokes {@link ArrayList#clear()}
     * @utbot.invokes {@link User#getSkippedArticles()}
     * @utbot.throwsException {@link NullPointerException} in: user.getSkippedArticles().clear();
     */
    @Test
    @DisplayName("resetUserPreferences: user.getSkippedArticles().clear() : True -> ThrowNullPointerException")
    public void testResetUserPreferences_ThrowNullPointerException_3() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
        User user = ((User) createInstance("com.example.newsrecommendationsystem.User"));
        ArrayList readArticles = new ArrayList();
        readArticles.add(null);
        readArticles.add(null);
        readArticles.add(null);
        setField(user, "com.example.newsrecommendationsystem.User", "readArticles", readArticles);
        setField(user, "com.example.newsrecommendationsystem.User", "likedArticles", readArticles);
        
        /* This test fails because method [com.example.newsrecommendationsystem.Admin.resetUserPreferences] produces [java.lang.NullPointerException]
            com.example.newsrecommendationsystem.Admin.resetUserPreferences(Admin.java:46) */
        admin.resetUserPreferences(user);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.toString

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method toString()

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#toString()}
     * @utbot.returnsFrom {@code return "Admin{username='" + username + "'}";}
     */
    @Test
    @DisplayName("toString: -> return \"Admin{username='\" + username + \"'}\"")
    public void testToString_ReturnAdminusernamePlusUsernamePlus() throws Exception {
        Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));

        String actual = admin.toString();

        String expected = "Admin{username='null'}";

        assertEquals(expected, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Admin.verifyPassword

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method verifyPassword(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#verifyPassword(String)}
     * @utbot.invokes com.example.newsrecommendationsystem.Admin#hashPassword(java.lang.String)
     * @utbot.invokes {@link java.security.MessageDigest#getInstance(String)}
     * @utbot.triggersRecursion of {@code hashPassword}
     * @utbot.throwsException {@link ClassCastException} in: return this.password.equals(hashPassword(enteredPassword));
     */
    @Test
    @DisplayName("verifyPassword: return this.password.equals(hashPassword(enteredPassword)) : True -> ThrowClassCastException")
    public void testVerifyPassword_ThrowClassCastException() throws Exception {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(GetInstance.class);
            Instance instance = ((Instance) createInstance("sun.security.jca.GetInstance$Instance"));
            short[] impl = {};
            setField(instance, "sun.security.jca.GetInstance$Instance", "impl", impl);
            (mockedStatic.when(() -> GetInstance.getInstance(any(String.class), any(Class.class), any(String.class)))).thenReturn(instance);
            Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));

            /* This test fails because method [com.example.newsrecommendationsystem.Admin.verifyPassword] produces [java.lang.ClassCastException: The object with type java.lang.Object can not be casted to java.security.MessageDigestSpi] */
            admin.verifyPassword(null);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method verifyPassword(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Admin}
     * @utbot.methodUnderTest {@link Admin#verifyPassword(String)}
     * @utbot.invokes com.example.newsrecommendationsystem.Admin#hashPassword(java.lang.String)
     * @utbot.invokes {@link java.security.MessageDigest#getInstance(String)}
     * @utbot.throwsException {@link NullPointerException}
     */
    @Test
    @DisplayName("verifyPassword:  -> ThrowNullPointerException")
    public void testVerifyPassword_ThrowNullPointerException() throws Exception {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(GetInstance.class);
            Instance instance = ((Instance) createInstance("sun.security.jca.GetInstance$Instance"));
            SunRsaSign provider = ((SunRsaSign) createInstance("sun.security.rsa.SunRsaSign"));
            setField(instance, "sun.security.jca.GetInstance$Instance", "provider", provider);
            (mockedStatic.when(() -> GetInstance.getInstance(any(String.class), any(Class.class), any(String.class)))).thenReturn(instance);
            Admin admin = ((Admin) createInstance("com.example.newsrecommendationsystem.Admin"));
            String password = "";
            setField(admin, "com.example.newsrecommendationsystem.Admin", "password", password);

            assertThrows(NullPointerException.class, () -> admin.verifyPassword(null));
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion
}
