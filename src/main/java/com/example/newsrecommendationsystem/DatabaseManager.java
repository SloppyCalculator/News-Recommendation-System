package com.example.newsrecommendationsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;


public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:user-article.db";

    public static Connection connect() {
        try {
            // Connect to SQLite database
            Connection conn = DriverManager.getConnection(URL);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    }




