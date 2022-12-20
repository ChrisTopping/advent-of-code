package com.cpt.adventofcode.solution.year2022.day9;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rope {

    private final List<Stack<Position>> knots;

    public static Rope ofSize(int length) {
        List<Stack<Position>> knots = IntStream.range(0, length).mapToObj(value -> {
                    Stack<Position> positions = new Stack<>();
                    positions.push(Position.initial());
                    return positions;
                })
                .collect(Collectors.toList());

        return new Rope(knots);
    }

    public void applyCommand(Command command) {
        Stack<Position> previousKnot = knots.get(0);

        Position previousHead = previousKnot.peek();
        Position currentHead = previousHead.calculateNewPosition(command);
        previousKnot.push(currentHead);

        for (int knotIndex = 1; knotIndex < knots.size(); knotIndex++) {
            Stack<Position> currentKnot = this.knots.get(knotIndex);
            Position currentKnotPreviousPosition = currentKnot.peek();
            if (currentKnotPreviousPosition.isTouching(previousKnot.peek())) {
                currentKnot.push(currentKnotPreviousPosition);
            } else {
                currentKnot.push(previousHead);
            }
            previousKnot = currentKnot;
        }
    }

    public Set<Position> getUniqueTailPositions() {
        return new HashSet<>(knots.get(knots.size() - 1));
    }


}
