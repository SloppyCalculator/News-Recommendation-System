package com.example.newsrecommendationsystem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SportsArticle extends AbstractArticle {
    private final String apiURL = "https://newsapi.org/v2/everything?language=en&q=sports";

    public SportsArticle(String title, String author, String description, String url, Date publishedAt, String content, String source) {
        super(title, author, description, url, publishedAt, content, source);
    }

    @Override
    public String getCategory() {
        return "Sports";
    }

    public ArrayList<AbstractArticle> fetchArticles(String category) {
        ArrayList<AbstractArticle> articles = new ArrayList<>();
        try {
            URL url = new URL(apiURL + "&apiKey=" + super.getApiKey());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray articlesArray = jsonResponse.getJSONArray("articles");

                for (int i = 0; i < articlesArray.length(); i++) {
                    JSONObject jsonArticle = articlesArray.getJSONObject(i);
                    AbstractArticle article = parseArticleFromJson(jsonArticle);
                    articles.add(article);
                }
            } else {
                System.out.println("Error: Unable to fetch articles. HTTP Response Code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Error fetching articles: " + e.getMessage());
        }
        return articles;
    }

    private AbstractArticle parseArticleFromJson(JSONObject jsonArticle) {
        String title = jsonArticle.getString("title");
        String author = jsonArticle.optString("author", "Unknown");
        String description = jsonArticle.optString("description", "");
        String url = jsonArticle.optString("url", "");
        String content = jsonArticle.optString("content", "");
        String source = jsonArticle.getJSONObject("source").optString("name", "Unknown");

        // Parse the published date
        String publishedAtStr = jsonArticle.optString("publishedAt", "");
        Date publishedAt = null;
        try {
            if (!publishedAtStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                publishedAt = dateFormat.parse(publishedAtStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SportsArticle(title, author, description, url, publishedAt, content, source);
    }


}
