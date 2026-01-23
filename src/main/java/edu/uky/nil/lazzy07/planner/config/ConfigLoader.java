package edu.uky.nil.lazzy07.planner.config;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigLoader {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .enable(JsonReadFeature.ALLOW_TRAILING_COMMA.mappedFeature())
            .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS.mappedFeature())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static PlannerConfig load(Path path){
        if(!Files.exists(path)){
            throw new IllegalArgumentException("Config file not found: " + path.toAbsolutePath());
        }

        try {
            PlannerConfig config = MAPPER.readValue(Files.readString(path), PlannerConfig.class);
            validate(config);
            return config;
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading config file: " + path.toAbsolutePath());
        }
    }

    private static void validate(PlannerConfig c){
        if (c.domain() == null) throw new IllegalArgumentException("Missing: domain");
        if (isBlank(c.domain().name())) throw new IllegalArgumentException("Missing: domain.name");
        if (isBlank(c.domain().file())) throw new IllegalArgumentException("Missing: domain.file");

        if (c.search() == null) throw new IllegalArgumentException("Missing: search");
        if (c.search().plan() == null) throw new IllegalArgumentException("Missing: search.plan");
        if (c.search().plan().maxLength() <= 0) {
            throw new IllegalArgumentException("search.plan.max-length must be > 0");
        }

        if (c.llm() == null) throw new IllegalArgumentException("Missing: llm");
        if (c.llm().prompt() == null) throw new IllegalArgumentException("Missing: llm.prompt");
        if (isBlank(c.llm().prompt().converter())) {
            throw new IllegalArgumentException("Missing: llm.prompt.converter");
        }
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
