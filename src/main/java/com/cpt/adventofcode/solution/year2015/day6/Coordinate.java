package com.cpt.adventofcode.solution.year2015.day6;

import com.cpt.adventofcode.helpers.Strings;
import lombok.Getter;

import java.util.List;

@Getter
class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(String input) {
        List<Integer> values = Strings.splitAndCast(input, ",", Strings.Type.INTEGER);
        this.x = values.get(0);
        this.y = values.get(1);
    }
}
