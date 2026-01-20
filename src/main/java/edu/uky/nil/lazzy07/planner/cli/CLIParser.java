package edu.uky.nil.lazzy07.planner.cli;

import org.apache.commons.cli.*;

public class CLIParser {
    public CLIParser(String[] args){
        Options options = getOptions();

        CommandLineParser parser = new DefaultParser();

        @SuppressWarnings("deprecation")
        HelpFormatter formatter = new HelpFormatter();

        CommandLine cmd = null;

        try{
            cmd = parser.parse(options, args);

            if(cmd.hasOption("h")){
                formatter.printHelp("blunt-sabre", options);
                return;
            }
        } catch (ParseException e){
            System.out.println(e.getMessage());
            formatter.printHelp("Blunt Sabre", options);
        }

        
    }

    private static Options getOptions() {
        Options options = new Options();

        // Setting the prompt version (Optional)
        Option promptVersion = new Option("p", "prompt-version", true, "Prompt Version");
        options.addOption(promptVersion);

        // Setting Domain name (required)
        Option domainName = new Option("d", "domain-name", true,"Name of the story domain");
        domainName.setRequired(true);
        options.addOption(domainName);

        // Setting usage of heuristic (optional)
        Option useHeuristic = new Option("u", "heuristic", true, "Heuristic to be used");
        options.addOption(useHeuristic);

        // Setting problem files folder
        Option problemFileFolder = new Option("f", "problem-folder", true, "Problem file folder");

        options.addOption("h", "help", false, "Print this help message");

        return options;
    }
}
