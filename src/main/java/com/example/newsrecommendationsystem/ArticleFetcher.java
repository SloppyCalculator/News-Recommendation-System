package com.example.newsrecommendationsystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArticleFetcher {
    private final String apiUrl = "https://newsapi.org/v2/everything?language=en&q=world";
    private final String apiKey = "34b9b7bd81cc46468cdee82db6e08dd5";

    // Constructor that initializes the API URL and API key
    /*public ArticleFetcher(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }*/

    // Fetch articles from the API and return them as a list
    public ArrayList<Articles> fetchArticles() {
        ArrayList<Articles> articles = new ArrayList<>();
        try {
            // Set up the URL connection
            URL url = new URL(apiUrl + "?apiKey=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Check if the request was successful
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // Parse the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Convert response to JSON and extract articles
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray articlesArray = jsonResponse.getJSONArray("articles");

                // Process each article in the JSON array
                for (int i = 0; i < articlesArray.length(); i++) {
                    JSONObject jsonArticle = articlesArray.getJSONObject(i);
                    Articles article = parseArticleFromJson(jsonArticle);
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

    // Helper method to parse an Article object from a JSON object
    private Articles parseArticleFromJson(JSONObject jsonArticle) {
        String title = jsonArticle.getString("title");
        String content = jsonArticle.getString("description"); // Example field
        String category = jsonArticle.has("category") ? jsonArticle.getString("category") : "General";

        return new Articles(title, content, category);
    }
}
