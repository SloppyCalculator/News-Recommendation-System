package com.example.newsrecommendationsystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;


public class User implements Profile{
    private int userID;
    private String username;
    private String passwordHash;
    private static final String SALT = "RandomSaltForSecurity";
    private ArrayList<Article> readArticles = new ArrayList<>();
    private ArrayList<Article> likedArticles = new ArrayList<>();
    private ArrayList<Article> skippedArticles = new ArrayList<>();
    private ArrayList<String> preferences = new ArrayList<>();
    private DatabaseManager connector;

    public User(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password);
    }

    public User(String username, String password, String state) {
        this.username = username;
        this.passwordHash = password;
    }

    public User(String username, String password, ArrayList<String> preferences) {
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.preferences = preferences;
    }



    public User(int id, String username, String password, ArrayList<String> preferences){
        this.userID = id;
        this.username = username;
        this.passwordHash = password;
        this.preferences = preferences;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String saltedPassword = SALT + password; // Add salt
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());

            // Convert hashed bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    public boolean verifyPassword(String password) {
        String hashedInput = hashPassword(password); // Hash the input password
        return hashedInput.equals(passwordHash); // Compare with stored hash
    }

    public ArrayList<Article> getReadArticles() {
        return readArticles;
    }

    public ArrayList<Article> getLikedArticles() {
        return likedArticles;
    }

    public ArrayList<Article> getSkippedArticles() {
        return skippedArticles;
    }

    public void addReadArticle(Article article) {
        if (!readArticles.contains(article)) {
            readArticles.add(article);
        }
    }

    public void addLikedArticle(Article article) {
        if (!likedArticles.contains(article)) {
            likedArticles.add(article);
        }
    }

    public void addSkippedArticle(Article article) {
        if (!skippedArticles.contains(article)) {
            skippedArticles.add(article);
        }
    }

    public void removeLikedArticle(Article article) {
        likedArticles.remove(article);
    }

    public void addPreference(String preference){
        preferences.add(preference);
    }

    public ArrayList<String> getPreferences(){
        return preferences;
    }

    @Override
    public String toString() {
        return "User{userID='" + userID + "', username='" + username + "'}";
    }

    public void changeUsername(String username){
        this.username = username;
    }

    public void changePassword(String password){
        this.passwordHash = hashPassword(password);

    }
    public int getUserID(){
        return userID;
    }
}

