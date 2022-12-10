package com.cpt.adventofcode.solution.year2022.day7.prompt.result;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;
import com.cpt.adventofcode.solution.year2022.day7.prompt.PromptType;

public class DirectoryResult extends Result {
    protected DirectoryResult(Prompt next, String name) {
        super(next, name);
    }

    @Override
    public PromptType getType() {
        return PromptType.DIRECTORY;
    }
}
