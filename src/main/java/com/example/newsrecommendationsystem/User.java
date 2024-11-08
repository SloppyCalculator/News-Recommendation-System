package com.example.newsrecommendationsystem;

import java.util.ArrayList;

public class User {
    private String userID;
    private String username;
    private String password;
    private ArrayList<Articles> readArticles = new ArrayList<>();
    private ArrayList<Articles> likedArticles = new ArrayList<>();
    private ArrayList<Articles> skippedArticles = new ArrayList<>();
}
