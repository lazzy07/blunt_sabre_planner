package edu.uky.nil.lazzy07.planner.heuristic;

public class NoneHeuristic extends Heuristic {
    public NoneHeuristic(){
        super("none");
    }

    @Override
    public long evaluate(long node) {
        return 1000;
    }
}
