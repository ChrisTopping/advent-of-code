package com.cpt.adventofcode.solution.year2021.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.SlidingWindow;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(
        year = 2021, day = 1, part = 2,
        description = "Sonar Sweep",
        link = "https://adventofcode.com/2021/day/1"
)
public class Day1Part2Solution2021 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        Stream<List<Integer>> slidingWindow = SlidingWindow.of(inputStream.map(Integer::parseInt)
                .collect(Collectors.toList()), 4);

        return slidingWindow
                .filter(this::isWindowIncreasing)
                .count();
    }

    private boolean isWindowIncreasing(List<Integer> integers) {
        return sum(integers.subList(0, 3)) < sum(integers.subList(1, 4));
    }

    private int sum(List<Integer> values) {
        return values.stream()
                .mapToInt(value -> value)
                .sum();
    }

}
