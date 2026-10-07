package com.studentfeedback.service;

import com.studentfeedback.config.AIConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LLMService {

    private final HttpClient httpClient;

    public LLMService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String ask(String question) throws IOException, InterruptedException {

        String apiKey = AIConfig.getLlmApiKey();

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "LLM_API_KEY environment variable is not configured."
            );
        }

        String model = AIConfig.getLlmModel();
        String apiUrl = AIConfig.getLlmApiUrl();

        String escapedQuestion = escapeJson(question);

        String requestBody = """
                {
                  "model": "%s",
                  "input": [
                    {
                      "role": "user",
                      "content": [
                        {
                          "type": "input_text",
                          "text": "%s"
                        }
                      ]
                    }
                  ]
                }
                """.formatted(model, escapedQuestion);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IOException(
                    "LLM API request failed. HTTP "
                            + response.statusCode()
                            + ": "
                            + response.body()
            );
        }

        return extractOutputText(response.body());
    }

    private String escapeJson(String text) {

        if (text == null) {
            return "";
        }

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\r", "\\r")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }

    private String extractOutputText(String json) {

        String marker = "\"output_text\"";

        int markerIndex = json.indexOf(marker);

        if (markerIndex >= 0) {

            int colonIndex = json.indexOf(":", markerIndex);

            if (colonIndex >= 0) {

                int firstQuote = json.indexOf("\"", colonIndex + 1);

                if (firstQuote >= 0) {

                    StringBuilder result = new StringBuilder();
                    boolean escaped = false;

                    for (int i = firstQuote + 1; i < json.length(); i++) {

                        char c = json.charAt(i);

                        if (escaped) {

                            switch (c) {
                                case 'n' -> result.append('\n');
                                case 'r' -> result.append('\r');
                                case 't' -> result.append('\t');
                                case '"' -> result.append('"');
                                case '\\' -> result.append('\\');
                                default -> result.append(c);
                            }

                            escaped = false;

                        } else if (c == '\\') {

                            escaped = true;

                        } else if (c == '"') {

                            return result.toString();

                        } else {

                            result.append(c);
                        }
                    }
                }
            }
        }

        return json;
    }
}