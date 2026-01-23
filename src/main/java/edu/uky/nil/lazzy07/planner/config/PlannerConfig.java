package edu.uky.nil.lazzy07.planner.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlannerConfig(
        Domain domain,
        Search search,
        LLM llm,
        Output output
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Domain(String name, String file){}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Search(
            Type type,
            Cost cost,
            Plan plan
    ){
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Type(String name, Map<String, Object> config){}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Cost(String type, Map<String, Object> config){}

        public record Plan(
                @JsonProperty("max-length") int maxLength,
                int utility
        ) {}
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record LLM(
            Prompt prompt,
            Cache cache
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Prompt(
                String version,
                String folder,
                String converter
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Cache(
                @JsonProperty("use-cache") boolean useCache,
                String folder
        ) {}
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Output(
            @JsonProperty("save-output") boolean saveOutput,
            String folder
    ) {}
}
