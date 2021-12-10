package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 9, part = 1,
        description = "Smoke Basin",
        link = "https://adventofcode.com/2021/day/9",
        tags = ""
)
public class Day9Part1Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return new Grid(inputStream.collect(Collectors.toList()))
                .countLocalMinima();
    }

    private static class Grid {
        private int[][] heightMatrix;

        private Grid(List<String> input) {
            initialiseGrid(input);
        }

        public int countLocalMinima() {
            int xLength = heightMatrix[0].length;
            int yLength = heightMatrix.length;

            List<Integer> minima = new ArrayList<>();
            for (int x = 1; x < xLength - 1; x++) {
                for (int y = 1; y < yLength - 1; y++) {
                    getIfMinima(x, y).map(integer -> ++integer).ifPresent(minima::add);
                }
            }

            return minima.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        private Optional<Integer> getIfMinima(int x, int y) {
            int value = this.heightMatrix[y][x];
            boolean isMinima = isMinima(x, y, value);
            return Optional.ofNullable(isMinima ? value : null);
        }

        private boolean isMinima(int x, int y, int value) {
            int above = this.heightMatrix[y - 1][x];
            int below = this.heightMatrix[y + 1][x];
            int left = this.heightMatrix[y][x - 1];
            int right = this.heightMatrix[y][x + 1];
            int min = min(above, below, left, right);
            return value < min;
        }

        private int min(int... values) {
            int min = Integer.MAX_VALUE;
            for (int currentValue : values) {
                if (currentValue < min) {
                    min = currentValue;
                }
            }
            return min;
        }

        private void initialiseGrid(List<String> input) {
            int xLength = input.get(0).length() + 2;
            int yLength = input.size() + 2;

            List<Integer> digits = input.stream()
                    .map(String::chars)
                    .flatMap(IntStream::boxed)
                    .map(i -> String.valueOf((char) (int) i))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            heightMatrix = new int[yLength][xLength];
            Arrays.stream(heightMatrix).forEach(ints -> Arrays.fill(ints, 9));

            for (int x = 1; x < xLength - 1; x++) {
                for (int y = 1; y < yLength - 1; y++) {
                    heightMatrix[y][x] = digits.get((y - 1) * (xLength - 2) + x - 1);
                }
            }
        }
    }

}