package com.cpt.adventofcode.solution.year2021.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(
        year = 2021, day = 1, part = 1,
        description = "Sonar Sweep",
        link = "https://adventofcode.com/2021/day/1"
)
public class Day1Part1Solution implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        Stream<List<Integer>> slidingWindow = SlidingWindow.of(inputStream.map(Integer::parseInt)
                .collect(Collectors.toList()), 2);

        return slidingWindow
                .filter(this::isIncreasing)
                .count();
    }

    private boolean isIncreasing(List<Integer> integers) {
        return integers.get(0) < integers.get(1);
    }

}
