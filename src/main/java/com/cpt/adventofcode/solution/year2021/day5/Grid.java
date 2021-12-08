package com.cpt.adventofcode.solution.year2021.day5;

import java.util.Arrays;

public class Grid {
    private final int[][] points;

    public Grid(int xSize, int ySize) {
        points = new int[xSize][ySize];
    }

    public void apply(Line line) {
        line.getPointsOnLine().forEach(point -> points[point.getX()][point.getY()]++);
    }

    public int sumAtOrAboveThreshold(int threshold) {
        return (int) Arrays.stream(points)
                .flatMapToInt(Arrays::stream)
                .filter(count -> count >= threshold)
                .count();
    }
}
