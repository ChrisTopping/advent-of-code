package com.cpt.adventofcode.solution.year2022.day9;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Command {

    private final Direction direction;
    private final int steps;

    public Command(String commandString) {
        String[] tokens = commandString.split(" ");
        this.direction = Direction.fromCharacter(tokens[0]);
        this.steps = Integer.parseInt(tokens[1]);
    }

    public Command(Direction direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public List<Command> split() {
        return IntStream.range(0, steps)
                .mapToObj(operand -> new Command(direction, 1))
                .collect(Collectors.toList());
    }

    protected enum Direction {
        UP("U", 0, 1),
        DOWN("D", 0, -1),
        LEFT("L", -1, 0),
        RIGHT("R", 1, 0);

        private final String directionCharacter;
        @Getter
        private final int horizontalStep;
        @Getter
        private final int verticalStep;

        Direction(String directionCharacter, int horizontalStep, int verticalStep) {
            this.directionCharacter = directionCharacter;
            this.horizontalStep = horizontalStep;
            this.verticalStep = verticalStep;
        }

        static Direction fromCharacter(String directionCharacter) {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.directionCharacter.equals(directionCharacter))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
