package com.cpt.adventofcode.solution.year2015.day6;

public class Grid {
    private boolean[][] lights = new boolean[1000][1000];

    public int countOn() {
        int on = 0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lights[i][j]) {
                    on += 1;
                }
            }
        }

        return on;
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
                lights[i][j] = true;
            }
        }
    }

    private void handleOff(Coordinate start, Coordinate end) {
        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                lights[i][j] = false;
            }
        }
    }

    private void handleToggle(Coordinate start, Coordinate end) {
        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                lights[i][j] = !lights[i][j];
            }
        }
    }
}
