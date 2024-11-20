package com.example.newsrecommendationsystem;

import java.util.ArrayList;

public class Admin implements Users{
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void Login(String username, String password) {

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void deleteUser(User user, ArrayList<User> userList) {
        userList.remove(user);
    }

    public void resetUserPreferences(User user) {
        user.getReadArticles().clear();
        user.getLikedArticles().clear();
        user.getSkippedArticles().clear();
    }

    @Override
    public String toString() {
        return "Admin{username='" + username + "'}";
    }
}
