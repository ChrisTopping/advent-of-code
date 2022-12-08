package com.cpt.adventofcode.solution.year2022.day5;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crane {

    private final boolean oneAtATime;

    public Crane(boolean oneAtATime) {
        this.oneAtATime = oneAtATime;
    }

    public void move(Commands commands, Stacks stacks) {
        commands.getCommands().forEach(command -> move(command, stacks));
    }

    private void move(Command command, Stacks stacks) {
        Stack<String> fromStack = stacks.get(command.getFrom());
        Stack<String> toStack = stacks.get(command.getTo());
        List<String> crates = IntStream
                .range(0, command.getCount())
                .mapToObj(value -> fromStack.pop())
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            if (!oneAtATime) {
                Collections.reverse(list);
            }
            return list;
        }));
        toStack.addAll(crates);
    }

}
