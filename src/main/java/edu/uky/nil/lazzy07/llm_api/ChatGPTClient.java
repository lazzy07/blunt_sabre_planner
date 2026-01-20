package edu.uky.nil.lazzy07.llm_api;

import com.fasterxml.jackson.databind.JsonNode;

public class ChatGPTClient extends LLMClient {
    public ChatGPTClient(String model, String cacheFolder, String apiKey) {
        super(model, cacheFolder, apiKey);
    }

    @Override
    public String respondText() {
        return "";
    }

    @Override
    public JsonNode respondJson() {
        return null;
    }
}
