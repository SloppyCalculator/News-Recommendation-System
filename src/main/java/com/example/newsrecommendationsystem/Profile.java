package com.example.newsrecommendationsystem;

public interface Profile {
    String getUsername();
    String getPassword();
    boolean verifyPassword(String password);
}
