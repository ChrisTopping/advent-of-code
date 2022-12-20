package com.cpt.adventofcode.solution.year2022.day9;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Position {

    private int horizontal;
    private int vertical;

    public static Position initial() {
        return new Position(0,0);
    }

    public Position calculateNewPosition(Command command) {
        int horizontalAdjustment = command.getSteps() * command.getDirection().getHorizontalStep();
        int verticalAdjustment = command.getSteps() * command.getDirection().getVerticalStep();
        return new Position(horizontal + horizontalAdjustment, vertical + verticalAdjustment);
    }

    public boolean isTouching(Position other) {
        return Math.abs(other.horizontal - this.horizontal) <= 1 && Math.abs(other.vertical - this.vertical) <= 1;
    }

}
