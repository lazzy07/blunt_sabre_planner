package edu.uky.nil.lazzy07;


import edu.uky.cs.nil.sabre.comp.CompiledAction;
import edu.uky.nil.lazzy07.planner.cli.CLIParser;
import edu.uky.nil.lazzy07.planner.cli.ParsedCLIArgs;
import edu.uky.nil.lazzy07.planner.core.PlannerCore;
import org.apache.commons.cli.ParseException;

public class App 
{
    public static void main( String[] args )
    {
        CLIParser parser = new CLIParser(args);

        ParsedCLIArgs parsedArgs = null;

        try {
            parsedArgs = parser.getParsedCLIArgs();
            PlannerCore planner = new PlannerCore(parsedArgs);
            planner.initializePlanner();

        } catch (ParseException e) {
            System.out.println("Error parsing CLI Arguments, planner stopped");
        }
    }
}
