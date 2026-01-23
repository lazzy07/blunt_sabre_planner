package edu.uky.nil.lazzy07.llm_api;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class LLMClient {
    private final String model;
    private final String cacheFolder;

    public LLMClient(String model, String cacheFolder) {
        this.model = model;
        this.cacheFolder = cacheFolder;
    }

    public String getModel() {
        return model;
    }

    public String getCacheFolder() {
        return cacheFolder;
    }

    public abstract void initialize();

    public abstract String respondText();

    public abstract JsonNode respondJson();
}
