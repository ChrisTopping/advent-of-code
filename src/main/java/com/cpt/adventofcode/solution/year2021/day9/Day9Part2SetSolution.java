package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@AdventOfCodeSolution(
        year = 2021, day = 9, part = 2,
        description = "Smoke Basin - Set",
        tags = "alternative",
        link = "https://adventofcode.com/2021/day/9"
)
public class Day9Part2SetSolution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return new Grid(inputStream.collect(Collectors.toList()))
                .sumBasinSizes()
                .subList(0, 3)
                .stream()
                .reduce((left, right) -> left * right)
                .orElse(0);
    }

    private static class Grid {
        private int[][] heightMatrix;

        private Grid(List<String> input) {
            initialiseGrid(input);
        }

        public List<Integer> sumBasinSizes() {
            List<Coord> localMinima = getLocalMinima();
            return localMinima.stream()
                    .map(coord -> getBasinCoords(new HashSet<>(List.of(coord))).size())
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }

        private Set<Coord> getBasinCoords(Set<Coord> pointsInBasin) {
            Set<Coord> surroundingCoords = pointsInBasin.stream().map(this::getSurroundingCoords).flatMap(Collection::stream).collect(Collectors.toSet());
            HashSet<Coord> copyOfSurroundingCoords = new HashSet<>(surroundingCoords);
            copyOfSurroundingCoords.removeAll(new HashSet<>(pointsInBasin));
            if (copyOfSurroundingCoords.stream().allMatch(coord -> 9 == coord.getValue())) {
                return pointsInBasin;
            } else {
                pointsInBasin.addAll(surroundingCoords.stream().filter(coord -> 9 != coord.getValue()).collect(Collectors.toSet()));
                return getBasinCoords(pointsInBasin);
            }
        }

        public List<Coord> getSurroundingCoords(Coord coord) {
            int x = coord.getX();
            int y = coord.getY();
            return asList(coord(x, y - 1), coord(x, y + 1), coord(x - 1, y), coord(x + 1, y));
        }

        public Coord coord(int x, int y) {
            return new Coord(x, y, heightMatrix[y][x]);
        }

        private List<Coord> getLocalMinima() {
            int xLength = heightMatrix[0].length;
            int yLength = heightMatrix.length;

            List<Coord> minima = new ArrayList<>();
            for (int x = 1; x < xLength - 1; x++) {
                for (int y = 1; y < yLength - 1; y++) {
                    if (isMinima(x, y)) minima.add(new Coord(x, y, heightMatrix[y][x]));
                }
            }
            return minima;
        }

        private boolean isMinima(int x, int y) {
            int value = this.heightMatrix[y][x];
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

        @RequiredArgsConstructor
        @ToString
        @EqualsAndHashCode
        private static class Coord {
            @Getter
            private final int x;
            @Getter
            private final int y;
            @Getter
            private final int value;
        }
    }

}