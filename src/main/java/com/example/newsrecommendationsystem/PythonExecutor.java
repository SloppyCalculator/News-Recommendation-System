package com.example.newsrecommendationsystem;

import java.io.*;

public class PythonExecutor {
    public static void main(String[] args) {
        try {
            // Path to Python 3 interpreter and script
            String pythonInterpreter = "src/main/resources/com/example/newsrecommendationsystem/python3";  // Adjust path if necessary
            String pythonScript = "src/main/resources/com/example/newsrecommendationsystem/categorizeArticles.py";  // Path to your Python script

            ProcessBuilder processBuilder = new ProcessBuilder(pythonInterpreter, pythonScript);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Capture output from Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to exit
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
