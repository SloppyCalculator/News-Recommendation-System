package com.example.newsrecommendationsystem;

import java.util.Date;

public abstract class AbstractArticle implements Article {
    protected String title;
    protected String author;
    protected String description;
    protected String url;
    protected Date publishedAt;
    protected String content;
    protected String source;
    private final String apiUrl = "https://newsapi.org/v2/everything?language=en&q=world";
    private final String apiKey = "34b9b7bd81cc46468cdee82db6e08dd5";

    public AbstractArticle(String title, String author, String description, String url, Date publishedAt, String content, String source) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;

    }



    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Date getPublishedAt() {
        return publishedAt;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public abstract String getCategory();


}
