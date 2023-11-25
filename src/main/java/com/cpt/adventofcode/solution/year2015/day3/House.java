package com.cpt.adventofcode.solution.year2015.day3;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class House {
    private final int x;
    private final int y;

    public House next(String direction) {
        return switch (direction) {
            case "^" -> new House(x, y + 1);
            case "v" -> new House(x, y - 1);
            case ">" -> new House(x + 1, y);
            case "<" -> new House(x - 1, y);
            default -> this;
        };
    }
}
