package edu.uky.nil.lazzy07.llm_api;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class ChatGPTClient extends LLMClient {
    Map<String, Object> jsonSchema = Map.of(

    );

    public ChatGPTClient(String cacheFolder) {
        super("gpt-5-mini", cacheFolder);
    }

    @Override
    public void initialize() {
        isAPIKeyValid();
    }

    private void isAPIKeyValid(){
        String apiKey = System.getenv("OPENAI_API_KEY");

        if(apiKey == null  || apiKey.isBlank()){
            throw new IllegalStateException("OPENAI_API_KEY not found!");
        }
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
