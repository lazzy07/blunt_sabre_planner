package edu.uky.nil.lazzy07.planner.cli;

import org.apache.commons.cli.*;

public class CLIParser {
    private CommandLine cmd = null;
    public CLIParser(String[] args){
        Options options = getOptions();

        CommandLineParser parser = new DefaultParser();

        @SuppressWarnings("deprecation")
        HelpFormatter formatter = new HelpFormatter();

        try{
            this.cmd = parser.parse(options, args);

            if(cmd.hasOption("h")){
                formatter.printHelp("blunt-sabre", options);
                return;
            }
        } catch (ParseException e){
            System.out.println(e.getMessage());
            formatter.printHelp("Blunt Sabre", options);
        }
    }

    public ParsedCLIArgs getParsedCLIArgs() throws ParseException {
        if(cmd == null){
            throw new ParseException("Error parsing cli arguments, planner stopped");
        }

        String promptVersion = cmd.getOptionValue("prompt-version");
        String domainName = cmd.getOptionValue("domain-name");
        String heuristic = cmd.getOptionValue("heuristic");
        String problemFolder = cmd.getOptionValue("problem-folder");
        int maxUtility = Integer.parseInt(cmd.getOptionValue("max-utility"));
        int maxPlanLength = Integer.parseInt(cmd.getOptionValue("max-plan-length"));
        String llmModel = cmd.getOptionValue("llm-model");
        String cacheFolder = cmd.getOptionValue("cache-folder");
        String promptTemplateFolder = cmd.getOptionValue("prompt-template-folder");

         return new ParsedCLIArgs(domainName,
                promptVersion,
                problemFolder,
                heuristic,
                maxPlanLength,
                maxUtility,
                llmModel,
                cacheFolder,
                promptTemplateFolder
        );
    }

    private static Options getOptions() {
        Options options = new Options();

        options.addOption("h", "help", false, "Print this help message");

        // Setting the prompt version (required)
        Option promptVersion = new Option("p", "prompt-version", true, "Prompt Version");
        promptVersion.setRequired(true);
        options.addOption(promptVersion);

        // Setting Domain name (required)
        Option domainName = new Option("d", "domain-name", true,"Name of the story domain");
        domainName.setRequired(true);
        options.addOption(domainName);

        // Setting usage of heuristic (required)
        Option useHeuristic = new Option("e", "heuristic", true, "Heuristic to be used");
        useHeuristic.setRequired(true);
        options.addOption(useHeuristic);

        // Setting problem files folder
        Option problemFileFolder = new Option("f", "problem-folder", true, "Problem file folder - default: problems/");
        options.addOption(problemFileFolder);

        // Setting the utility the planner needs to achieve (required)
        Option maxUtility = new Option("u", "max-utility", true, "Utility that the planner needs to achieve");
        maxUtility.setRequired(true);
        options.addOption(maxUtility);

        // Max plan length until the planner give up
        Option maxPlanLength = new Option("l", "max-plan-length", true, "Max plan length until the planner give up");
        maxPlanLength.setRequired(true);
        options.addOption(maxPlanLength);

        Option llmModel = new Option("m", "llm-model", true, "Selected llm Model - default: chatgpt-5-mini");
        options.addOption(llmModel);

        Option cacheFolder = new Option("c", "cache-folder", true, "Cache folder - default: .openai-cache/");
        options.addOption(cacheFolder);

        Option promptTemplateFolder = new Option("t", "prompt-template-folder", true, "Prompt template folder - default: prompt_templates/");
        options.addOption(promptTemplateFolder);

        return options;
    }
}
