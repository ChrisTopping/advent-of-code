package com.cpt.adventofcode.solution.year2022.day9;

import lombok.*;

import java.util.*;

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

    public Position calculateNewPosition(Direction direction) {
        int horizontalAdjustment = direction.getHorizontalStep();
        int verticalAdjustment = direction.getVerticalStep();
        return new Position(horizontal + horizontalAdjustment, vertical + verticalAdjustment);
    }

    public boolean isNotTouching(Position other) {
        return Math.abs(other.horizontal - this.horizontal) > 1 || Math.abs(other.vertical - this.vertical) > 1;
    }

    public Collection<Direction> getDirectionsOf(Position other) {
        Set<Direction> directions = new HashSet<>();
        if (isNotTouching(other)) {
            if (other.vertical > this.vertical) {
                directions.add(Direction.UP);
            } else if (other.vertical < this.vertical) {
                directions.add(Direction.DOWN);
            }

            if (other.horizontal > this.horizontal) {
                directions.add(Direction.RIGHT);
            } else if (other.horizontal < this.horizontal) {
                directions.add(Direction.LEFT);
            }
        }
        return directions;
    }

}
