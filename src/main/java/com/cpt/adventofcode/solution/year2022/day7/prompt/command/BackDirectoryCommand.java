package com.cpt.adventofcode.solution.year2022.day7.prompt.command;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;
import com.cpt.adventofcode.solution.year2022.day7.prompt.PromptType;

public class BackDirectoryCommand extends Command {
    protected BackDirectoryCommand(Prompt previous) {
        super(previous);
    }

    @Override
    public PromptType getType() {
        return PromptType.BACK_DIRECTORY;
    }
}
