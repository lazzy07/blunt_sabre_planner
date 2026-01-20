package edu.uky.nil.lazzy07.planner.heuristic;

public class HeuristicFactory {
    public static Heuristic CreateHeuristic(String type){
        switch(type){
            case "none":
                return new NoneHeuristic();
            default:
                return null;
        }
    }
}
