package com.cpt.adventofcode.solution.year2022.day7.prompt.command;


import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;

abstract class Command extends Prompt {
    public Command(Prompt previous) {
        super(previous);
    }
}
