package com.example.newsrecommendationsystem;

import java.sql.Timestamp;

public class UserArticleInteraction {
    private int userId;
    private int articleId;
    private String action;
    private Timestamp timestamp;

    public UserArticleInteraction(int userId, int articleId, String action, Timestamp timestamp) {
        this.userId = userId;
        this.articleId = articleId;
        this.action = action;
        this.timestamp = timestamp;
    }

    // Getters and setters for the fields

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
