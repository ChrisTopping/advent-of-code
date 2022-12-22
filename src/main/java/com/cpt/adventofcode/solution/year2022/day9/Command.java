package com.cpt.adventofcode.solution.year2022.day9;

import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@ToString
public class Command {

    private final Direction direction;
    private final int steps;

    public Command(String commandString) {
        String[] tokens = commandString.split(" ");
        this.direction = Direction.fromCharacter(tokens[0]);
        this.steps = Integer.parseInt(tokens[1]);
    }

    public Collection<Direction> breakOutDirections() {
        return IntStream.range(0, steps)
                .mapToObj(operand -> direction)
                .collect(Collectors.toList());
    }

}
