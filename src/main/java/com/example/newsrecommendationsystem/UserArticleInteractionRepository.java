package com.example.newsrecommendationsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserArticleInteractionRepository {
    private final DatabaseManager databaseManager;

    // Constructor to inject DatabaseManager
    public UserArticleInteractionRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    // Create the "user_article_interactions" table if it doesn't exist
    private void createTable() {
        String createSQL = """
            CREATE TABLE IF NOT EXISTS user_article_interactions (
                user_id INTEGER,
                article_id INTEGER,
                action TEXT CHECK(action IN ('read', 'liked', 'skipped')),
                timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
                PRIMARY KEY (user_id, article_id, action),
                FOREIGN KEY (user_id) REFERENCES users(id),
                FOREIGN KEY (article_id) REFERENCES articles(id)
            );
            """;
        try (Connection conn = databaseManager.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating table: " + e.getMessage(), e);
        }
    }

    // 1. Record a user action on an article (like, read, or skip)
    public boolean recordUserAction(int userId, int articleId, String action) {
        createTable(); // Ensure the table exists

        if (!isValidAction(action)) {
            System.err.println("Invalid action: " + action);
            return false;
        }

        // Check if an interaction with the same user_id, article_id, and action already exists
        String selectSQL = "SELECT COUNT(*) FROM user_article_interactions WHERE user_id = ? AND article_id = ? AND action = ?";
        String insertSQL = "INSERT INTO user_article_interactions (user_id, article_id, action, timestamp) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        String updateSQL = "UPDATE user_article_interactions SET timestamp = CURRENT_TIMESTAMP WHERE user_id = ? AND article_id = ? AND action = ?";

        try (Connection conn = databaseManager.connect();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {

            selectStmt.setInt(1, userId);
            selectStmt.setInt(2, articleId);
            selectStmt.setString(3, action);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // Record with same user_id, article_id, and action exists, so update it
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                    updateStmt.setInt(1, userId);
                    updateStmt.setInt(2, articleId);
                    updateStmt.setString(3, action);
                    return updateStmt.executeUpdate() > 0; // Return true if update is successful
                }
            } else {
                // No record exists, so insert a new one
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                    insertStmt.setInt(1, userId);
                    insertStmt.setInt(2, articleId);
                    insertStmt.setString(3, action);
                    return insertStmt.executeUpdate() > 0; // Return true if insertion is successful
                }
            }

        } catch (SQLException e) {
            System.err.println("Error recording user action: " + e.getMessage());
        }
        return false;
    }


    // 2. Retrieve all actions for a specific user
    public List<UserArticleInteraction> loadUserActions(int userId) {
        return loadUserActionsByAction(userId, null); // Load all actions for a user (no filter)
    }

    // 3. Retrieve all actions for a specific user and action type (e.g., "liked", "read", etc.)
    public List<UserArticleInteraction> loadUserActionsByAction(int userId, String action) {
        List<UserArticleInteraction> actions = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM user_article_interactions WHERE user_id = ?");

        // If action is provided, filter by action type as well
        if (action != null && !action.isEmpty() && isValidAction(action)) {
            query.append(" AND action = ?");
        }

        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query.toString())) {

            pstmt.setInt(1, userId);

            if (action != null && !action.isEmpty() && isValidAction(action)) {
                pstmt.setString(2, action);
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                actions.add(extractUserArticleInteractionFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error loading user actions: " + e.getMessage());
        }
        return actions;
    }

    // 4. Retrieve all actions for a specific article
    public List<UserArticleInteraction> loadArticleActions(int articleId) {
        List<UserArticleInteraction> actions = new ArrayList<>();
        String query = "SELECT * FROM user_article_interactions WHERE article_id = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, articleId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                actions.add(extractUserArticleInteractionFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error loading article actions: " + e.getMessage());
        }
        return actions;
    }

    // 5. Check if a user has performed a specific action on an article
    public boolean hasUserPerformedAction(int userId, int articleId, String action) {
        String query = "SELECT 1 FROM user_article_interactions WHERE user_id = ? AND article_id = ? AND action = ?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, articleId);
            pstmt.setString(3, action);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if action exists
        } catch (SQLException e) {
            System.err.println("Error checking user action: " + e.getMessage());
        }
        return false;
    }

    // Helper method: Extract UserArticleInteraction object from ResultSet
    private UserArticleInteraction extractUserArticleInteractionFromResultSet(ResultSet rs) throws SQLException {
        int userId = rs.getInt("user_id");
        int articleId = rs.getInt("article_id");
        String action = rs.getString("action");
        Timestamp timestamp = rs.getTimestamp("timestamp");
        return new UserArticleInteraction(userId, articleId, action, timestamp);
    }

    // Utility: Check if the action is valid (either "read", "liked", or "skipped")
    private boolean isValidAction(String action) {
        return action != null && (action.equals("read") || action.equals("liked") || action.equals("skipped"));
    }

    //Remove a user action for a specific article
    public boolean removeUserAction(int userId, int articleId, String action) {
        createTable(); // Ensure the table exists

        if (!isValidAction(action)) {
            System.err.println("Invalid action: " + action);
            return false;
        }

        String deleteSQL = "DELETE FROM user_article_interactions WHERE user_id = ? AND article_id = ? AND action = ?";

        try (Connection conn = databaseManager.connect();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

            deleteStmt.setInt(1, userId);
            deleteStmt.setInt(2, articleId);
            deleteStmt.setString(3, action);

            return deleteStmt.executeUpdate() > 0; // Returns true if a record was deleted
        } catch (SQLException e) {
            System.err.println("Error removing user action: " + e.getMessage());
        }
        return false;
    }

}
