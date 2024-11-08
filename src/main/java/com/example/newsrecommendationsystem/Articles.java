package com.example.newsrecommendationsystem;

public class Articles {
    private String title;
    private String content;
    private String category;
    private String author;
    private String publishedAt;

    // Constructor

    public Articles(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Articles(String title, String content, String category, String author, String publishedAt) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.author = author;
        this.publishedAt = publishedAt;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Published At: " + publishedAt + "\n" +
                "Category: " + category + "\n" +
                "Content: " + content + "\n";
    }

}
