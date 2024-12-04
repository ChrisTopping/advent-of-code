package com.cpt.adventofcode.solution.year2024.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.SlidingWindow;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 2, part = 1,
        description = "Red-Nosed Reports",
        link = "https://adventofcode.com/2024/day/2"
)
public class Day2Part1Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return Math.toIntExact(inputStream
                .map(s -> Arrays
                        .stream(s.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .filter(this::isSafe)
                .count());
    }

    private boolean isSafe(List<Integer> levels) {
        boolean isWithinRange = SlidingWindow.of(levels, 2)
                .allMatch(integers -> {
                    int diff = Math.abs(integers.get(0) - integers.get(1));
                    return 0 < diff && diff < 4;
                });
        return isWithinRange && ( isMonotonicallyIncreasing(levels)| isMonotonicallyDecreasing(levels));
    }

    public boolean isMonotonicallyIncreasing(List<Integer> levels) {
        return levels.equals(levels.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    public boolean isMonotonicallyDecreasing(List<Integer> levels) {
        return levels.equals(levels.stream().sorted().collect(Collectors.toList()));
    }

}