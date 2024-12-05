package com.example.newsrecommendationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Trial {
    private static final String DB_URL = "jdbc:sqlite:articles.db"; // Replace with your database path
    private static final String TABLE_NAME = "articles"; // Replace with your table name

    public static void main(String[] args) {
        String selectSQL = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("Articles Table Content:");
            System.out.println("----------------------------------------------------------");

            // Iterate through the ResultSet and print each row
            while (rs.next()) {
                String title = rs.getString("title");
                String pubDate = rs.getString("pubDate");
                String guid = rs.getString("guid");
                String link = rs.getString("link");
                String description = rs.getString("description");
                String category = rs.getString("category");

                System.out.println("Title: " + title);
                System.out.println("Publication Date: " + pubDate);
                System.out.println("GUID: " + guid);
                System.out.println("Link: " + link);
                System.out.println("Description: " + description);
                System.out.println("Category: " + category);
                System.out.println("----------------------------------------------------------");
            }

        } catch (Exception e) {
            System.err.println("Error retrieving articles: " + e.getMessage());
        }
    }
}
