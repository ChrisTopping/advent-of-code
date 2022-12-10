package com.cpt.adventofcode.solution.year2022.day7.prompt.command;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;
import com.cpt.adventofcode.solution.year2022.day7.prompt.PromptType;
import com.cpt.adventofcode.solution.year2022.day7.prompt.command.Command;

public class ListCommand extends Command {
    protected ListCommand(Prompt next) {
        super(next);
    }

    @Override
    public PromptType getType() {
        return PromptType.LIST;
    }
}
