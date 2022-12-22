package com.cpt.adventofcode.solution.year2022.day9;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.Stack;

@AllArgsConstructor
public class Knot {
    @Getter
    private final Stack<Position> positions;

    public static Knot initial() {
        Stack<Position> positions = new Stack<>();
        positions.push(Position.initial());
        return new Knot(positions);
    }

    public Position getCurrent() {
        return positions.peek();
    }

    public void move(Direction direction) {
        Position next = getCurrent().calculateNewPosition(direction);
        positions.push(next);
    }

    public void moveTowards(Knot other) {
        Position otherCurrent = other.getCurrent();
        Position position = getCurrent();

        Collection<Direction> directions = position.getDirectionsOf(otherCurrent);
        for (Direction direction : directions) {
            position = position.calculateNewPosition(direction);
        }
        positions.push(position);
    }

}
