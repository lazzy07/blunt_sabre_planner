package edu.uky.nil.lazzy07.planner.cli;

public class ParsedCLIArgs {
    private String domainName = "";
    private String domainFolder = "problems/";
    private String promptVersion = "v1.0";
    private String heuristicType = "none";
    private int maxPlanLength = 3;
    private int maxUtility = 1;
    private String llmModel = "gpt-5-mini";
    private String cacheFolder = ".openai-cache/";
    private String promptTemplateFolder = "prompt-templates/";

    /***
     * Custom values
     * @param domainName Name of the domain
     * @param heuristicType Heuristic type
     * @param maxPlanLength Max plan length that planner will stop at
     * @param maxUtility Utility that planner needs to achieve
     */
    public ParsedCLIArgs(String domainName, String promptVersion, String domainFolder, String heuristicType, int maxPlanLength, int maxUtility, String llmModel, String cacheFolder, String promptTemplateFolder){
        this.domainName = domainName;

        if(domainFolder != null){
            this.domainFolder = domainFolder;
        }

        this.promptVersion = promptVersion;
        this.heuristicType = heuristicType;
        this.maxPlanLength = maxPlanLength;
        this.maxUtility = maxUtility;

        if(cacheFolder != null){
            this.cacheFolder = cacheFolder;
        }

        if(llmModel != null){
            this.llmModel = llmModel;
        }

        if(promptTemplateFolder != null){
            this.promptTemplateFolder = promptTemplateFolder;
        }
    }

    /***
     * Default constructor with default values
     */
    public ParsedCLIArgs(){

    }

    public String getLlmModel() {
        return llmModel;
    }

    public String getCacheFolder() {
        return cacheFolder;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getDomainFolder() {
        return domainFolder;
    }

    public String getPromptVersion() {
        return promptVersion;
    }

    public String getHeuristicType() {
        return heuristicType;
    }

    public int getMaxPlanLength() {
        return maxPlanLength;
    }

    public int getMaxUtility() {
        return maxUtility;
    }

    public String getPromptTemplateFolder() {
        return promptTemplateFolder;
    }

    public String toString(){
        return """
               \n************** Planner settings **************
               ----- Domain --------
               Domain Name: %s
               Domain Folder: %s
               
               ----- Search --------
               Heuristic type: %s
               Max plan length: %d
               Utility: %d
               
               ----- LLM --------
               Prompt version: %s
               Model: %s
               Cache folder: %s
               Prompt template folder: %s
               
               **********************************************
               
               """.formatted(domainName, domainFolder, heuristicType, maxPlanLength, maxUtility, promptVersion, llmModel, cacheFolder, promptTemplateFolder);
    }
}
