package com.cpt.adventofcode.solution.year2022.day7.prompt.command;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;
import com.cpt.adventofcode.solution.year2022.day7.prompt.PromptType;
import lombok.Getter;

public class ChangeDirectoryCommand extends Command {

    @Getter
    private String directoryName;

    protected ChangeDirectoryCommand(Prompt next, String directoryName) {
        super(next);
        this.directoryName = directoryName;
    }

    @Override
    public PromptType getType() {
        return PromptType.CHANGE_DIRECTORY;
    }
}
