package edu.uky.nil.lazzy07.prompting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PromptSnippet {
    private String promptVersion;
    private Path promptPath;
    private String finalPromptInstruction;

    public void initialize(){
        try {
            this.finalPromptInstruction = Files.readString(this.promptPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
