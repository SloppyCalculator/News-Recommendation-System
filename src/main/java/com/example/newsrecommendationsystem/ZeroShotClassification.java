package com.example.newsrecommendationsystem;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class ZeroShotClassification {
    private static final String API_URL = "https://api-inference.huggingface.co/models/facebook/bart-large-mnli";
    private static final String API_TOKEN = "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";


    
    public static String categorizeDescription(String description) {
        String[] candidateLabels = {"technology", "sports", "politics", "entertainment", "health",
                "business", "lifestyle", "education"};
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                return classifyText(description, candidateLabels);
            } catch (IOException e) {
                e.printStackTrace();
                return "Other";
            }
        });

        try {
            return future.get(); // Block until the result is available
        } catch (Exception e) {
            e.printStackTrace();
            return "Other";
        }
    }


    private static String classifyText(String text, String[] candidateLabels) throws IOException {
        OkHttpClient client = new OkHttpClient();

        JSONObject payload = new JSONObject();
        payload.put("inputs", text);
        payload.put("parameters", new JSONObject().put("candidate_labels", new JSONArray(Arrays.asList(candidateLabels))));

        RequestBody body = RequestBody.create(
                payload.toString(),
                MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_TOKEN)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            return parseResponse(responseBody);
        }
    }

    private static String parseResponse(String responseBody) {
        JSONObject responseJson = new JSONObject(responseBody);
        JSONArray labels = responseJson.getJSONArray("labels");
        return labels.getString(0); // Return the label with the highest confidence
    }
}

