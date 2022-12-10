package com.cpt.adventofcode.solution.year2022.day7.prompt;

import lombok.Getter;

public abstract class Prompt {
    @Getter
    private final Prompt next;

    public Prompt(Prompt next) {
        this.next = next;
    }

    public abstract PromptType getType();
}
