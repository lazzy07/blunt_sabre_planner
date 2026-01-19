package edu.uky.nil.lazzy07;


import edu.uky.cs.nil.sabre.comp.CompiledAction;
import edu.uky.nil.lazzy07.planner.cli.CLIParser;
import edu.uky.nil.lazzy07.planner.core.PlannerCore;

public class App 
{
    public static void main( String[] args )
    {
        CLIParser parser = new CLIParser(args);
        PlannerCore planner = new PlannerCore();
    }
}
