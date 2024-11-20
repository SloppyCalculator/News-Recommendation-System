package com.example.newsrecommendationsystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;


public class User implements Users{
    private String userID;
    private String username;
    private String passwordHash;
    private static final String SALT = "RandomSaltForSecurity";
    private ArrayList<AbstractArticle> readArticles = new ArrayList<>();
    private ArrayList<AbstractArticle> likedArticles = new ArrayList<>();
    private ArrayList<AbstractArticle> skippedArticles = new ArrayList<>();

    public User(String username, String password) {
        this.userID = UUID.randomUUID().toString();
        this.username = username;
        this.passwordHash = hashPassword(password);
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
    public void Login(String username, String password) {


    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Access to raw password is not allowed.");
    }

    public boolean verifyPassword(String password) {
        String hashedInput = hashPassword(password); // Hash the input password
        return hashedInput.equals(passwordHash); // Compare with stored hash
    }

    public ArrayList<AbstractArticle> getReadArticles() {
        return readArticles;
    }

    public ArrayList<AbstractArticle> getLikedArticles() {
        return likedArticles;
    }

    public ArrayList<AbstractArticle> getSkippedArticles() {
        return skippedArticles;
    }

    public void addReadArticle(AbstractArticle article) {
        if (!readArticles.contains(article)) {
            readArticles.add(article);
        }
    }

    public void addLikedArticle(AbstractArticle article) {
        if (!likedArticles.contains(article)) {
            likedArticles.add(article);
        }
    }

    public void addSkippedArticle(AbstractArticle article) {
        if (!skippedArticles.contains(article)) {
            skippedArticles.add(article);
        }
    }

    public void removeLikedArticle(AbstractArticle article) {
        likedArticles.remove(article);
    }

    @Override
    public String toString() {
        return "User{userID='" + userID + "', username='" + username + "'}";
    }
}
