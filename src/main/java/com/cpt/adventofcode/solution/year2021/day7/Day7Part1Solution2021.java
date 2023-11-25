package com.cpt.adventofcode.solution.year2021.day7;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 7, part = 1,
        description = "The Treachery of Whales",
        link = "https://adventofcode.com/2021/day/7"
)
public class Day7Part1Solution2021 implements Solution<Integer> {
    @Override
    public Integer solve(Stream<String> inputStream) {
        List<Integer> positions = inputStream
                .flatMap(s -> Stream.of(s.split(",")))
                .map(Integer::valueOf)
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());

        Integer median = positions.get(positions.size() / 2);

        return sumFuelToPosition(positions, median);
    }

    private int sumFuelToPosition(List<Integer> positions, int toPosition) {
        return positions.stream()
                .map(integer -> Math.abs(integer - toPosition))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
