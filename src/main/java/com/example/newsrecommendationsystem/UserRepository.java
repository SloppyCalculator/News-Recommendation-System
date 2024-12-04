package com.example.newsrecommendationsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private final DatabaseManager databaseManager;

    // Constructor to inject DatabaseManager
    public UserRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    // Create the "users" table if it doesn't exist
    private void createTable() {
        String createSQL = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL,
                preferences TEXT
            );
            """;
        try (Connection conn = databaseManager.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating table: " + e.getMessage(), e);
        }
    }

    // 1. Add a new user
    public boolean createUser(String username, String password, ArrayList<String> preferences) {
        createTable(); // Ensure table exists
        String preferencesString = convertListToString(preferences); // Convert preferences to String
        String insertSQL = "INSERT INTO users (username, password, preferences) VALUES (?, ?, ?)";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, preferencesString);
            return pstmt.executeUpdate() > 0; // Return true if insertion is successful
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
        return false;
    }

    // 2. Retrieve a user by username
    public User loadUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error loading user by username: " + e.getMessage());
        }
        return null;
    }

    // 3. Retrieve a user by ID
    public User loadUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error loading user by ID: " + e.getMessage());
        }
        return null;
    }

    // 4. Retrieve all users
    public List<User> loadAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection conn = databaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error loading all users: " + e.getMessage());
        }
        return users;
    }

    // 5. Update username
    public boolean updateUsername(int userId, String newUsername) {
        String updateSQL = "UPDATE users SET username = ? WHERE id = ?";
        return executeUpdate(updateSQL, newUsername, userId);
    }

    // 6. Update password
    public boolean updatePassword(int userId, String newPassword) {
        String updateSQL = "UPDATE users SET password = ? WHERE id = ?";
        System.out.println(newPassword);
        return executeUpdate(updateSQL, newPassword, userId);
    }

    // 7. Update preferences
    public boolean updatePreferences(int userId, ArrayList<String> newPreferences) {
        String preferencesString = convertListToString(newPreferences); // Convert preferences to String
        String updateSQL = "UPDATE users SET preferences = ? WHERE id = ?";
        return executeUpdate(updateSQL, preferencesString, userId);
    }

    // 8. Delete a user by ID
    public boolean deleteUserById(int userId) {
        String deleteSQL = "DELETE FROM users WHERE id = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setInt(1, userId);
            return pstmt.executeUpdate() > 0; // Return true if deletion is successful
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
        return false;
    }

    // 9. Authenticate a user
    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if user exists
        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
        }
        return false;
    }

    // 10. Check if a username exists
    public boolean doesUsernameExist(String username) {
        String query = "SELECT 1 FROM users WHERE username = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Return true if at least one result is found
        } catch (SQLException e) {
            System.err.println("Error checking if username exists: " + e.getMessage());
        }
        return false;
    }


    // Helper method: Extract a User object from a ResultSet
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String preferencesString = rs.getString("preferences");
        ArrayList<String> preferences = convertStringToList(preferencesString); // Convert preferences to ArrayList
        return new User(id, username, password, preferences);
    }

    // Helper method: Execute update queries
    private boolean executeUpdate(String query, String param, int userId) {
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, param);
            pstmt.setInt(2, userId);
            return pstmt.executeUpdate() > 0; // Return true if update is successful
        } catch (SQLException e) {
            System.err.println("Error executing update: " + e.getMessage());
        }
        return false;
    }

    // Utility: Convert ArrayList to String
    private String convertListToString(ArrayList<String> preferences) {
        if (preferences == null || preferences.isEmpty()) {
            return ""; // Return empty string for null or empty list
        }
        return String.join(",", preferences); // Join preferences with a comma delimiter
    }

    // Utility: Convert String to ArrayList
    private ArrayList<String> convertStringToList(String preferencesString) {
        if (preferencesString == null || preferencesString.isEmpty()) {
            return new ArrayList<>(); // Return empty list for null or empty string
        }
        List<String> list = Arrays.asList(preferencesString.split(","));
        return new ArrayList<>(list); // Convert List to ArrayList
    }

    // 11. Save or update user preferences
    public boolean saveUserPreferences(int userId, ArrayList<String> preferences) {
        String preferencesString = convertListToString(preferences); // Convert preferences to String
        String updateSQL = "UPDATE users SET preferences = ? WHERE id = ?";
        return executeUpdate(updateSQL, preferencesString, userId);
    }




}
