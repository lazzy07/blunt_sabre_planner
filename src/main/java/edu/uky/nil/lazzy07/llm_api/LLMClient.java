package edu.uky.nil.lazzy07.llm_api;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class LLMClient {
    private final String model;
    private final String cacheFolder;
    private final String apiKey;

    public LLMClient(String model, String cacheFolder, String apiKey) {
        this.model = model;
        this.cacheFolder = cacheFolder;
        this.apiKey = apiKey;
    }

    public String getModel() {
        return model;
    }

    public String getCacheFolder() {
        return cacheFolder;
    }

    public String getApiKey() {
        return apiKey;
    }

    public abstract void initialize();

    public abstract String respondText();

    public abstract JsonNode respondJson();
}
