package com.example.newsrecommendationsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private final DatabaseManager dbManager;

    public ArticleRepository(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public static void createArticleTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS articles (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "pubDate DATE NOT NULL," +
                "guid TEXT NOT NULL," +
                "link TEXT NOT NULL," +
                "description TEXT NOT NULL," +
                "category TEXT);";
        DatabaseManager dbManager = new DatabaseManager();
        try (Connection conn = dbManager.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CREATE - Add a single article
    public boolean addArticle(Article article) {
        createArticleTable();
        String query = "INSERT INTO articles (title, pubDate, guid, link, description, category) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, article.getTitle());
            statement.setDate(2, new java.sql.Date(article.getPubDate().getTime()));
            statement.setString(3, article.getGuid());
            statement.setString(4, article.getLink());
            statement.setString(5, article.getDescription());
            statement.setString(6, article.getCategory());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ ALL - Retrieve all articles
    public ArrayList<Article> getAllArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        String query = "SELECT id, title, pubDate, guid, link, description, category FROM articles";

        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("pubDate"),
                        resultSet.getString("guid"),
                        resultSet.getString("link"),
                        resultSet.getString("description"),
                        resultSet.getString("category")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    // READ BY ID - Get an article using its ID
    public Article getArticleById(int id) {
        String query = "SELECT id, title, pubDate, guid, link, description, category FROM articles WHERE id = ?";
        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("pubDate"),
                        resultSet.getString("guid"),
                        resultSet.getString("link"),
                        resultSet.getString("description"),
                        resultSet.getString("category")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ BY TITLE - Get an article's link using its title
    public String getArticleLinkByTitle(String title) {
        String query = "SELECT link FROM articles WHERE title = ?";
        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("link");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE - Update an article
    public boolean updateArticle(Article article) {
        String query = "UPDATE articles SET title = ?, pubDate = ?, guid = ?, link = ?, description = ?, category = ? WHERE id = ?";
        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, article.getTitle());
            statement.setDate(2, new java.sql.Date(article.getPubDate().getTime()));
            statement.setString(3, article.getGuid());
            statement.setString(4, article.getLink());
            statement.setString(5, article.getDescription());
            statement.setString(6, article.getCategory());
            statement.setInt(7, article.getId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Remove an article using its ID
    public boolean deleteArticle(int id) {
        String query = "DELETE FROM articles WHERE id = ?";
        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ BY CATEGORY - Get all articles related to a specific category
    public List<Article> getArticlesByCategory(String category) {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT id, title, pubDate, guid, link, description, category FROM articles WHERE category = ?";

        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, category);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("pubDate"),
                        resultSet.getString("guid"),
                        resultSet.getString("link"),
                        resultSet.getString("description"),
                        resultSet.getString("category")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    public ArrayList<Article> getArticlesByCategoryPreferences(ArrayList<String> categories) {
        ArrayList<Article> articles = new ArrayList<>();

        // Building the query with placeholders for categories
        StringBuilder query = new StringBuilder("SELECT id, title, pubDate, guid, link, description, category FROM articles WHERE category IN (");

        // Dynamically append placeholders for categories
        for (int i = 0; i < categories.size(); i++) {
            query.append("?");
            if (i < categories.size() - 1) {
                query.append(", ");
            }
        }
        query.append(")");

        // Execute the query with the provided categories
        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            // Set the category parameters in the prepared statement
            for (int i = 0; i < categories.size(); i++) {
                statement.setString(i + 1, categories.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            // Add each matching article to the list
            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("pubDate"),
                        resultSet.getString("guid"),
                        resultSet.getString("link"),
                        resultSet.getString("description"),
                        resultSet.getString("category")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    public List<Article> getArticlesByIds(List<Integer> ids) {
        List<Article> articles = new ArrayList<>();

        if (ids == null || ids.isEmpty()) {
            return articles; // Return empty list if no IDs are provided
        }

        // Build the query with placeholders for each ID
        StringBuilder query = new StringBuilder("SELECT id, title, pubDate, guid, link, description, category FROM articles WHERE id IN (");

        // Dynamically add placeholders for the IDs
        for (int i = 0; i < ids.size(); i++) {
            query.append("?");
            if (i < ids.size() - 1) {
                query.append(", ");
            }
        }
        query.append(")");

        try (Connection connection = dbManager.connect();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            // Set the ID parameters in the prepared statement
            for (int i = 0; i < ids.size(); i++) {
                statement.setInt(i + 1, ids.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            // Populate the list with the resulting articles
            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("pubDate"),
                        resultSet.getString("guid"),
                        resultSet.getString("link"),
                        resultSet.getString("description"),
                        resultSet.getString("category")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
