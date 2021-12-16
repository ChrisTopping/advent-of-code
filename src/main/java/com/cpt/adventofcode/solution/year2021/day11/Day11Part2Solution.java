package com.cpt.adventofcode.solution.year2021.day11;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 11, part = 2,
        description = "Dumbo Octopus",
        link = "https://adventofcode.com/2021/day/11#part2",
        tags = ""
)
public class Day11Part2Solution implements Solution<Integer> {

    private int xSize;
    private int ySize;

    @Override
    public Integer solve(Stream<String> inputStream) {
        int[][] levels = initialiseLevels(inputStream);
        xSize = levels.length;
        ySize = levels[0].length;
        int iteration = 0;
        while (true) {
            iteration++;
            iterate(levels);
            if (isAllZeros(levels)) {
                return iteration;
            }
        }
    }

    private boolean isAllZeros(int[][] levels) {
        return Arrays.stream(levels).flatMap(ints -> Arrays.stream(ints).boxed()).allMatch(integer -> integer == 0);
    }

    private void iterate(int[][] levels) {
        for (int row = 0; row < ySize; row++) {
            for (int col = 0; col < xSize; col++) {
                levels[row][col]++;
            }
        }
        updateFlashes(levels);
    }

    private void updateFlashes(int[][] levels) {
        boolean flashed = false;
        for (int row = 0; row < ySize; row++) {
            for (int col = 0; col < xSize; col++) {
                if (levels[row][col] > 9) {
                    levels[row][col] = 0;
                    flashed = true;
                    incrementNeighbours(levels, row, col);
                }
            }
        }
        if (flashed) {
            updateFlashes(levels);
        }
    }

    private void incrementNeighbours(int[][] levels, int row, int col) {
        int[] delta = new int[]{-1, 0, 1};
        for (int i = 0; i < delta.length; i++) {
            for (int j = 0; j < delta.length; j++) {
                if (i == 1 && j == 1)
                    continue;
                if (isInBounds(levels, row + delta[i], col + delta[j]))
                    levels[row + delta[i]][col + delta[j]]++;
            }
        }
    }

    private boolean isInBounds(int[][] levels, int row, int col) {
        return (row >= 0 && col >= 0 && row < levels.length && col < levels[0].length && levels[row][col] != 0);
    }

    private int[][] initialiseLevels(Stream<String> inputStream) {
        int[][] levels = inputStream
                .map(s -> s.split(""))
                .map(strings -> Arrays.stream(strings).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        xSize = levels[0].length;
        ySize = levels.length;
        return levels;
    }

}
