/*package com.example.newsrecommendationsystem;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.search.*;
import org.apache.lucene.queryparser.classic.QueryParser;

import java.io.*;
import java.util.*;

public class RecommendationEngine {

    private RAMDirectory indexDirectory;
    private IndexWriter writer;
    private ArticleRepository articleRepository;

    // Constructor initializes the in-memory index and repository
    public RecommendationEngine(ArticleRepository articleRepository) throws IOException {
        this.articleRepository = articleRepository;
        indexDirectory = new RAMDirectory();
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(indexDirectory, config);
    }

    // Method to add articles to the index
    public void addArticlesToIndex() throws IOException {
        List<Article> articles = articleRepository.getAllArticles();
        for (Article article : articles) {
            String articleId = String.valueOf(article.getId());
            if (article.getDescription() != null && articleId != null) {
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
                doc.add(new TextField("content", article.getDescription(), Field.Store.YES));
                doc.add(new TextField("id", articleId, Field.Store.YES)); // Store ID as a string
                writer.addDocument(doc);
            } else {
                System.err.println("Skipping article with null description or ID");
            }
        }

        // Commit the changes to the index
        writer.commit();
        System.out.println("All articles added to the index.");

        // Verify the number of documents in the index
        DirectoryReader reader = DirectoryReader.open(indexDirectory);
        System.out.println("Number of documents in index: " + reader.numDocs());
        reader.close();
    }

    // Method to close the writer and commit the changes
    public void closeWriter() throws IOException {
        writer.close();
    }

    // Method to compute the similarity between articles with weighted recommendations
    public List<String> getRecommendations(List<String> readArticleIds, List<String> likedArticleIds, List<String> skippedArticleIds) throws IOException, ParseException {
        if (indexDirectory.listAll().length == 0) {
            System.err.println("Index is empty or not found.");
            return new ArrayList<>();
        }
        // Try opening the DirectoryReader
        try {
            DirectoryReader reader = DirectoryReader.open(indexDirectory);
            IndexSearcher searcher = new IndexSearcher(reader);
            searcher.setSimilarity(new ClassicSimilarity());

            List<String> recommendations = new ArrayList<>();

            for (String articleId : readArticleIds) {
                recommendations.addAll(getSimilarArticles(articleId, searcher, readArticleIds, likedArticleIds, skippedArticleIds, 1.0, 0.0, -0.5));
            }

            for (String articleId : likedArticleIds) {
                recommendations.addAll(getSimilarArticles(articleId, searcher, readArticleIds, likedArticleIds, skippedArticleIds, 1.5, 0.0, -0.5));
            }

            for (String articleId : skippedArticleIds) {
                recommendations.addAll(getSimilarArticles(articleId, searcher, readArticleIds, likedArticleIds, skippedArticleIds, 0.0, 0.0, -1.0));
            }

            // Remove duplicates from the recommendations list
            Set<String> uniqueRecommendations = new HashSet<>(recommendations);
            recommendations.clear();
            recommendations.addAll(uniqueRecommendations);

            reader.close();
            return recommendations;
            // Proceed with your logic using the reader...
        } catch (IOException e) {
            System.err.println("Error opening the index: " + e.getMessage());
            return new ArrayList<>();
        }

    }

    // Helper method to get similar articles
    private List<String> getSimilarArticles(String articleId, IndexSearcher searcher, List<String> readArticleIds, List<String> likedArticleIds, List<String> skippedArticleIds, double readWeight, double likedWeight, double skippedWeight) throws IOException, ParseException {
        List<String> similarArticles = new ArrayList<>();

        TermQuery termQuery = new TermQuery(new Term("id", articleId));
        TopDocs topDocs = searcher.search(termQuery, 1);

        if (topDocs.totalHits.value == 0) {
            System.err.println("No document found with ID: " + articleId);
            return similarArticles;
        }

        org.apache.lucene.document.Document doc = searcher.doc(topDocs.scoreDocs[0].doc);
        String articleContent = doc.get("content");

        if (articleContent == null || articleContent.isEmpty()) {
            System.err.println("No content found for article ID: " + articleId);
            return similarArticles;
        }

        QueryParser parser = new QueryParser("content", new StandardAnalyzer());
        Query query = parser.parse(QueryParser.escape(articleContent));

        TopDocs results = searcher.search(query, 10);

        for (ScoreDoc scoreDoc : results.scoreDocs) {
            org.apache.lucene.document.Document resultDoc = searcher.doc(scoreDoc.doc);
            String candidateArticleId = resultDoc.get("id");

            if (!readArticleIds.contains(candidateArticleId) && !likedArticleIds.contains(candidateArticleId) && !skippedArticleIds.contains(candidateArticleId)) {
                double similarityScore = scoreDoc.score;
                if (readArticleIds.contains(candidateArticleId)) {
                    similarityScore *= readWeight;
                } else if (likedArticleIds.contains(candidateArticleId)) {
                    similarityScore *= likedWeight;
                } else if (skippedArticleIds.contains(candidateArticleId)) {
                    similarityScore *= skippedWeight;
                }

                if (similarityScore > 0) {
                    similarArticles.add(candidateArticleId);
                }
            }
        }

        return similarArticles;
    }
}*/

package com.example.newsrecommendationsystem;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class RecommendationEngine {

    private RAMDirectory indexDirectory;
    private IndexWriter writer;
    private ArticleRepository articleRepository;

    // Constructor initializes the in-memory index and repository
    public RecommendationEngine(ArticleRepository articleRepository) throws IOException {
        this.articleRepository = articleRepository;
        indexDirectory = new RAMDirectory();
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(indexDirectory, config);
    }

    // Method to add articles to the index using concurrency
    public void addArticlesToIndexConcurrently() throws IOException, InterruptedException {
        List<Article> articles = articleRepository.getAllArticles();
        int numThreads = Runtime.getRuntime().availableProcessors(); // Number of threads to use
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int batchSize = Math.max(1, articles.size() / numThreads);
        List<List<Article>> partitions = new ArrayList<>();

        for (int i = 0; i < articles.size(); i += batchSize) {
            partitions.add(articles.subList(i, Math.min(i + batchSize, articles.size())));
        }

        for (List<Article> batch : partitions) {
            executor.submit(() -> {
                try {
                    for (Article article : batch) {
                        String articleId = String.valueOf(article.getId());
                        if (article.getDescription() != null && articleId != null) {
                            org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
                            doc.add(new TextField("content", article.getDescription(), Field.Store.YES));
                            doc.add(new TextField("id", articleId, Field.Store.YES));
                            synchronized (writer) {
                                writer.addDocument(doc); // Synchronize access to IndexWriter
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS); // Wait for all tasks to complete
        writer.commit();
        System.out.println("All articles added to the index in parallel.");
    }

    // Method to close the writer
    public void closeWriter() throws IOException {
        writer.close();
    }

    // Method to compute recommendations concurrently
    public List<String> getRecommendationsConcurrently(List<String> readArticleIds, List<String> likedArticleIds, List<String> skippedArticleIds) throws IOException {
        if (indexDirectory.listAll().length == 0) {
            System.err.println("Index is empty or not found.");
            return new ArrayList<>();
        }

        DirectoryReader reader = DirectoryReader.open(indexDirectory);
        IndexSearcher searcher = new IndexSearcher(reader);
        searcher.setSimilarity(new ClassicSimilarity());

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<CompletableFuture<List<String>>> futures = new ArrayList<>();

        // Process readArticleIds concurrently
        for (String articleId : readArticleIds) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return getSimilarArticles(articleId, searcher, readArticleIds, likedArticleIds, skippedArticleIds, 1.0, 0.0, -0.5);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                    return new ArrayList<>();
                }
            }, executor));
        }

        // Process likedArticleIds concurrently
        for (String articleId : likedArticleIds) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return getSimilarArticles(articleId, searcher, readArticleIds, likedArticleIds, skippedArticleIds, 1.5, 0.0, -0.5);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                    return new ArrayList<>();
                }
            }, executor));
        }

        // Process skippedArticleIds concurrently
        for (String articleId : skippedArticleIds) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return getSimilarArticles(articleId, searcher, readArticleIds, likedArticleIds, skippedArticleIds, 0.0, 0.0, -1.0);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                    return new ArrayList<>();
                }
            }, executor));
        }

        // Combine results
        List<String> recommendations = futures.stream()
                .map(CompletableFuture::join) // Wait for each future to complete
                .flatMap(Collection::stream) // Flatten the lists
                .distinct() // Remove duplicates
                .toList();

        executor.shutdown();
        reader.close();

        return recommendations;
    }

    // Helper method to get similar articles
    private List<String> getSimilarArticles(String articleId, IndexSearcher searcher, List<String> readArticleIds, List<String> likedArticleIds, List<String> skippedArticleIds, double readWeight, double likedWeight, double skippedWeight) throws IOException, ParseException {
        List<String> similarArticles = new ArrayList<>();

        TermQuery termQuery = new TermQuery(new Term("id", articleId));
        TopDocs topDocs = searcher.search(termQuery, 1);

        if (topDocs.totalHits.value == 0) {
            System.err.println("No document found with ID: " + articleId);
            return similarArticles;
        }

        org.apache.lucene.document.Document doc = searcher.doc(topDocs.scoreDocs[0].doc);
        String articleContent = doc.get("content");

        if (articleContent == null || articleContent.isEmpty()) {
            System.err.println("No content found for article ID: " + articleId);
            return similarArticles;
        }

        QueryParser parser = new QueryParser("content", new StandardAnalyzer());
        Query query = parser.parse(QueryParser.escape(articleContent));

        TopDocs results = searcher.search(query, 10);

        for (ScoreDoc scoreDoc : results.scoreDocs) {
            org.apache.lucene.document.Document resultDoc = searcher.doc(scoreDoc.doc);
            String candidateArticleId = resultDoc.get("id");

            if (!readArticleIds.contains(candidateArticleId) && !likedArticleIds.contains(candidateArticleId) && !skippedArticleIds.contains(candidateArticleId)) {
                double similarityScore = scoreDoc.score;
                if (readArticleIds.contains(candidateArticleId)) {
                    similarityScore *= readWeight;
                } else if (likedArticleIds.contains(candidateArticleId)) {
                    similarityScore *= likedWeight;
                } else if (skippedArticleIds.contains(candidateArticleId)) {
                    similarityScore *= skippedWeight;
                }

                if (similarityScore > 0) {
                    similarArticles.add(candidateArticleId);
                }
            }
        }

        return similarArticles;
    }
}

