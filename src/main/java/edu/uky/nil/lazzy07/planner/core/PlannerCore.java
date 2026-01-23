package edu.uky.nil.lazzy07.planner.core;

import edu.uky.cs.nil.sabre.Session;
import edu.uky.cs.nil.sabre.comp.CompiledProblem;
import edu.uky.cs.nil.sabre.io.ParseException;
import edu.uky.cs.nil.sabre.prog.ProgressionSearch;
import edu.uky.cs.nil.sabre.ptree.ProgressionTree;
import edu.uky.cs.nil.sabre.ptree.ProgressionTreeSpace;
import edu.uky.nil.lazzy07.llm_api.ChatGPTClient;
import edu.uky.nil.lazzy07.llm_api.LLMClient;
import edu.uky.nil.lazzy07.planner.cli.ParsedCLIArgs;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class PlannerCore {
    ParsedCLIArgs plannerConfig;
    Session session;
    ProgressionSearch search;
    ProgressionTreeMap treeMap;
    LLMClient llmModel;

    public PlannerCore(ParsedCLIArgs args){
        this.plannerConfig = args;
        this.session = new Session();

    }

    public ParsedCLIArgs getPlannerConfig() {
        return this.plannerConfig;
    }

    public void initializePlanner(){

        System.out.println("Planner initialization started...");
        System.out.println(this.plannerConfig.toString());

        String plannerPath = plannerConfig.getDomainFolder() + plannerConfig.getDomainName();
        try {
            this.session.setProblem(new File(plannerPath + ".txt"));
            this.search = (ProgressionSearch) session.getSearch();
            try {
                this.treeMap = getProgressionTreeMap(search);
                this.llmModel = this.getLLMModel();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static ProgressionTreeMap getProgressionTreeMap(ProgressionSearch search) throws NoSuchFieldException, IllegalAccessException {
        Field spaceField = ProgressionSearch.class.getDeclaredField("space");
        spaceField.setAccessible(true);
        ProgressionTreeSpace space = (ProgressionTreeSpace) spaceField.get(search);
        Field treeField = ProgressionTreeSpace.class.getDeclaredField("tree");
        treeField.setAccessible(true);
        ProgressionTree tree = (ProgressionTree) treeField.get(space);

        // Create the progression tree map
        CompiledProblem problem = search.problem;
        return new ProgressionTreeMap(tree, problem);
    }

    private LLMClient getLLMModel(){
        switch(this.plannerConfig.getLlmModel()){
            case "gpt-5-mini":
                return new ChatGPTClient(this.plannerConfig.getCacheFolder());
            default:
                return null;
        }
    }
}
