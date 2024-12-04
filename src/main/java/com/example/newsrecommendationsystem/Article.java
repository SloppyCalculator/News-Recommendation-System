package com.example.newsrecommendationsystem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

public class Article {
    private int id;
    private String title;
    private Date pubDate;
    private String guid;
    private String link;
    private String description;
    private String category;
    private String actions;

    // Constructor for creating an Article object
    public Article(String title, Date pubDate, String guid, String link, String description, String category) {
        this.title = title;
        this.pubDate = pubDate;
        this.guid = guid;
        this.link = link;
        this.description = description;
        this.category = category;
    }

    // Constructor for fetching an Article from the database
    public Article(int id, String title, Date pubDate, String guid, String link, String description, String category) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.guid = guid;
        this.link = link;
        this.description = description;
        this.category = category;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Method to fetch and scrape article content from a URL
    public static String scrapeArticleContent(String url) {
        String content = "";

        try {
            // Connect to the website and parse the HTML content
            Document doc = Jsoup.connect(url).get();

            // Extract the title of the article (optional, can be removed if not needed)
            String title = doc.title();
            System.out.println("Title: " + title);

            // Extract the content of the article using the specific attribute
            Elements articleContent = doc.select("div[data-component=text-block]");

            // If the article content is found, extract the text
            if (!articleContent.isEmpty()) {
                // Extract and concatenate text from each block
                for (Element block : articleContent) {
                    content += block.text() + "\n";
                }
            } else {
                System.out.println("Article content not found.");
            }
        } catch (IOException e) {
            System.out.println("Error while scraping the article: " + e.getMessage());
        }

        return content;
    }


    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}
