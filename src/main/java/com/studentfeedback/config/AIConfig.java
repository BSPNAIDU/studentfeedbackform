package com.studentfeedback.config;

public class AIConfig {

    private AIConfig() {
        // Prevent object creation
    }

    public static String getLlmApiKey() {
        return System.getenv("LLM_API_KEY");
    }

    public static String getLlmApiUrl() {
        String url = System.getenv("LLM_API_URL");

        if (url == null || url.isBlank()) {
            return "https://api.openai.com/v1/responses";
        }

        return url;
    }

    public static String getLlmModel() {
        String model = System.getenv("LLM_MODEL");

        if (model == null || model.isBlank()) {
            return "gpt-5-mini";
        }

        return model;
    }

    public static String getSearchApiKey() {
        return System.getenv("SEARCH_API_KEY");
    }

    public static String getSearchApiUrl() {
        String url = System.getenv("SEARCH_API_URL");

        if (url == null || url.isBlank()) {
            return "";
        }

        return url;
    }
}