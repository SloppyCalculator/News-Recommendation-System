package com.example.newsrecommendationsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Admin implements Users{
    private String username;
    private String password;
    private static final String SALT = "RandomSaltForSecurity";

    public Admin(String username, String password) {
        this.username = username;
        this.password = hashPassword(password);
    }

    public Admin(){
        loadAdminCredentials();
    }


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

    private void loadAdminCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader("admin_credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    this.username = line.substring(10).trim();
                } else if (line.startsWith("Password: ")) {
                    this.password = line.substring(10).trim();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading admin credentials from file", e);
        }
    }

    public boolean verifyPassword(String enteredPassword) {
        return this.password.equals(hashPassword(enteredPassword));
    }


}
