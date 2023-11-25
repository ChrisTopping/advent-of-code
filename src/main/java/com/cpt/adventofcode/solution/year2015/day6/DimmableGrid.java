package com.cpt.adventofcode.solution.year2015.day6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DimmableGrid {
    private int[][] lights = new int[1000][1000];

    public int countOn() {
        return Arrays.stream(lights)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    public void handle(Instruction instruction) {
        switch (instruction.getAction()) {
            case TURN_ON -> handleOn(instruction.getStart(), instruction.getEnd());
            case TURN_OFF -> handleOff(instruction.getStart(), instruction.getEnd());
            case TOGGLE -> handleToggle(instruction.getStart(), instruction.getEnd());
        }
    }

    private void handleOn(Coordinate start, Coordinate end) {
        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                lights[i][j] = lights[i][j] + 1;
            }
        }
    }

    private void handleOff(Coordinate start, Coordinate end) {
        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                lights[i][j] = lights[i][j] <= 0 ? 0 : lights[i][j] - 1;
            }
        }
    }

    private void handleToggle(Coordinate start, Coordinate end) {
        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                lights[i][j] = lights[i][j] + 2;
            }
        }
    }
}
