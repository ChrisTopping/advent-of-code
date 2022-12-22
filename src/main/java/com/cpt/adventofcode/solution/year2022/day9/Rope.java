package com.cpt.adventofcode.solution.year2022.day9;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rope {

    private final List<Knot> knots;

    public static Rope ofSize(int length) {
        List<Knot> knots = IntStream.range(0, length)
                .mapToObj(value -> Knot.initial())
                .collect(Collectors.toList());

        return new Rope(knots);
    }

    public void moveHead(Direction direction) {
        Knot previousKnot = knots.get(0);
        previousKnot.move(direction);

        for (int knotIndex = 1; knotIndex < knots.size(); knotIndex++) {
            Knot currentKnot = knots.get(knotIndex);
            Position currentKnotPosition = currentKnot.getCurrent();
            Position previousKnotPosition = previousKnot.getCurrent();

            if (currentKnotPosition.isNotTouching(previousKnotPosition)) {
                currentKnot.moveTowards(previousKnot);
            }
            previousKnot = currentKnot;
        }
    }

    public int countUniqueTailPositions() {
        return new HashSet<>(knots.get(knots.size() - 1).getPositions()).size();
    }
}
