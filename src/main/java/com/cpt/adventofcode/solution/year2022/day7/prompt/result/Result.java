package com.cpt.adventofcode.solution.year2022.day7.prompt.result;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;
import lombok.Getter;

abstract class Result extends Prompt {

    @Getter
    private final String name;

    public Result(Prompt next, String name) {
        super(next);
        this.name = name;
    }
}
