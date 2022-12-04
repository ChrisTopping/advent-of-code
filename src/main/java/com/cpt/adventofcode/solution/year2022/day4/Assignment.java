package com.cpt.adventofcode.solution.year2022.day4;

import lombok.Getter;

@Getter
public class Assignment {
    final int lower;
    final int upper;

    Assignment(String line) {
        String[] sections = line.split("-");
        this.lower = Integer.parseInt(sections[0]);
        this.upper = Integer.parseInt(sections[1]);
    }

    boolean isWithin(Assignment other) {
        return (other.lower >= this.lower && other.upper <= this.upper);
    }

    boolean intersectsWith(Assignment other) {
        return (other.lower <= this.lower && other.upper >= this.lower) || (other.lower <= this.upper && other.upper >= this.upper);
    }
}
