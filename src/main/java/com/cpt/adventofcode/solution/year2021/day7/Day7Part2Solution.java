package com.cpt.adventofcode.solution.year2021.day7;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 7, part = 2,
        description = "The Treachery of Whales",
        link = "https://adventofcode.com/2021/day/7"
)
public class Day7Part2Solution implements Solution<Integer> {
    @Override
    public Integer solve(Stream<String> inputStream) {
        List<Integer> positions = inputStream
                .flatMap(s -> Stream.of(s.split(",")))
                .map(Integer::valueOf)
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());

        int sum = positions.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int average = Math.floorDiv(sum, positions.size() - 1);

        int floorFuel = sumFuelToPosition(positions, average);
        int ceilFuel = sumFuelToPosition(positions, average + 1);

        return Math.min(floorFuel, ceilFuel);
    }

    private int sumFuelToPosition(List<Integer> positions, int toPosition) {
        return positions.stream()
                .map(integer -> calculateFuel(integer, toPosition))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int calculateFuel(int from, int to) {
        int distance = Math.abs(from - to);
        return distance * (distance + 1) / 2;
    }
}
