package com.cpt.adventofcode.solution.year2021.day5;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Data
public class Line {

    private static final String COORDINATE_DELIMITER = " -> ";

    private final List<Point> pointsOnLine;

    public Line(String lineString) {
        String[] points = lineString.split(COORDINATE_DELIMITER);
        pointsOnLine = calculatePointsOnLine(new Point(points[0]), new Point(points[1]));
    }

    private List<Point> calculatePointsOnLine(Point p1, Point p2) {
        int pointsCount = Math.max(Math.abs(p1.getX() - p2.getX()), Math.abs(p1.getY() - p2.getY()));
        int xDelta = (p2.getX() - p1.getX()) / pointsCount;
        int yDelta = (p2.getY() - p1.getY()) / pointsCount;

        List<Point> points = new ArrayList<>(asList(p1, p2));
        for (int i = 1; i <= pointsCount - 1; i++) {
            points.add(new Point(p1.getX() + (i * xDelta), p1.getY() + (i * yDelta)));
        }
        return points;
    }

    public boolean isOrtholinear() {
        return pointsOnLine.size() <= 1
                || (pointsOnLine.get(0).getX() == pointsOnLine.get(1).getX())
                || (pointsOnLine.get(0).getY() == pointsOnLine.get(1).getY());
    }
}
