package com.cpt.adventofcode.solution.year2022.day9;

import lombok.Getter;

import java.util.Arrays;

enum Direction {
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
