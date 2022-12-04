package com.cpt.adventofcode.solution.year2022.day4;

import lombok.Getter;

@Getter
public class Pair {
    private final Assignment first;
    private final Assignment second;

    Pair(String line) {
        String[] lines = line.split(",");
        this.first = new Assignment(lines[0]);
        this.second = new Assignment(lines[1]);
    }

}
