package com.cpt.adventofcode.solution.year2021.day5;

import lombok.Data;

@Data
public class Point {
    private static final String COORDINATE_DELIMITER = ",";

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String pointString) {
        String[] coordinates = pointString.split(COORDINATE_DELIMITER);
        this.x = Integer.parseInt(coordinates[0]);
        this.y = Integer.parseInt(coordinates[1]);
    }
}
