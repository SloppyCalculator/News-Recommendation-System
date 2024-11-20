package com.example.newsrecommendationsystem;

import java.util.Date;

public interface Article {
    String getTitle();
    String getAuthor();
    String getDescription();
    String getUrl();
    Date getPublishedAt();
    String getContent();
    String getSource();
    String getCategory();
}
