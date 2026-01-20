package edu.uky.nil.lazzy07.planner.heuristic;

/***
 * Heuristic abstract class, extends all the supported abstract types.
 */
public abstract class Heuristic {
    public final String name;

    public Heuristic(String name){
        this.name = name;
    }

    public abstract long evaluate(long node);
}
