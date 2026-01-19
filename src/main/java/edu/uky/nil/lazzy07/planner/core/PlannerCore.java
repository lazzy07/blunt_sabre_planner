package edu.uky.nil.lazzy07.planner.core;

public class PlannerCore {
    private String promptVersion = "v0.1"; /// System prompt version that the planner should use.
    private String domainName = "";

    public void setPromptVersion(String version){
        this.promptVersion = version;
    }

    public void setDomainName(String domainName){
        this.domainName = domainName;
    }
}
