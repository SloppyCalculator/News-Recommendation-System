package com.example.newsrecommendationsystem;

public class UserSession {
    private static UserSession instance;
    private String username;

    private UserSession() {}

    // Creating a new user session
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Set username to that of user logging in
    public void setUsername(String username) {
        this.username = username;
    }

    // Get username of user currently using
    public String getUsername() {
        return username;
    }

    // Clear session on logOut
    public void clearSession() {
        instance = null; // Reset the session on logout.
    }
}

