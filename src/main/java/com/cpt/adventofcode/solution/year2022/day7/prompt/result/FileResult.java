package com.cpt.adventofcode.solution.year2022.day7.prompt.result;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;
import com.cpt.adventofcode.solution.year2022.day7.prompt.PromptType;
import lombok.Getter;

public class FileResult extends Result {

    @Getter
    private final long size;

    protected FileResult(Prompt next, String name, long size) {
        super(next, name);
        this.size = size;
    }

    @Override
    public PromptType getType() {
        return PromptType.FILE;
    }
}
