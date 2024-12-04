package com.example.newsrecommendationsystem;

public interface Users {
    String getUsername();
    String getPassword();
    boolean verifyPassword(String password);
}
