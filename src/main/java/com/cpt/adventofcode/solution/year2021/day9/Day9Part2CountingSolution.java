package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(
        year = 2021, day = 9, part = 2,
        description = "Smoke Basin - Counting",
        link = "https://adventofcode.com/2021/day/9"
)
public class Day9Part2CountingSolution implements Solution<Integer> {

    private int[][] heights;

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> input = inputStream.collect(Collectors.toList());
        int xLength = input.get(0).length() + 2;
        int yLength = input.size() + 2;

        initialiseHeights(input, xLength, yLength);

        List<Integer> basinCoordinateCounts = new ArrayList<>();
        for (int y = 1; y < yLength - 1; y++) {
            for (int x = 1; x < xLength - 1; x++) {
                int currentValue = heights[y][x];
                if (heights[y - 1][x] < currentValue) {
                    basinCoordinateCounts.add(countBasinCoordinates(x, y - 1));
                }

                if (heights[y + 1][x] < currentValue) {
                    basinCoordinateCounts.add(countBasinCoordinates(x, y + 1));
                }

                if (heights[y][x - 1] < currentValue) {
                    basinCoordinateCounts.add(countBasinCoordinates(x - 1, y));
                }

                if (heights[y][x + 1] < currentValue) {
                    basinCoordinateCounts.add(countBasinCoordinates(x + 1, y));
                }
            }
        }

        List<Integer> basinsOfInterest = basinCoordinateCounts.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).subList(0, 3);
        return basinsOfInterest.get(0) * basinsOfInterest.get(1) * basinsOfInterest.get(2);
    }

    private void initialiseHeights(List<String> input, int xLength, int yLength) {
        heights = new int[yLength][xLength];
        Arrays.stream(heights).forEach(ints -> Arrays.fill(ints, 9));

        for (int x = 1; x < xLength - 1; x++) {
            for (int y = 1; y < yLength - 1; y++) {
                heights[y][x] = Integer.parseInt(input.get(y - 1).substring(x - 1, x));
            }
        }
    }

    private Integer countBasinCoordinates(int x, int y) {
        heights[y][x] = 9;
        return (y > 0 ? countBasinCoordinatesAbove9(x, y - 1) : 0)
                + (y < heights.length - 1 ? countBasinCoordinatesAbove9(x, y + 1) : 0)
                + (x > 0 ? countBasinCoordinatesAbove9(x - 1, y) : 0)
                + (y < heights[0].length - 1 ? countBasinCoordinatesAbove9(x + 1, y) : 0)
                + 1;
    }

    private int countBasinCoordinatesAbove9(int x, int y) {
        int value = heights[y][x];
        return (value != 9) ? countBasinCoordinates(x, y) : 0;
    }

}
