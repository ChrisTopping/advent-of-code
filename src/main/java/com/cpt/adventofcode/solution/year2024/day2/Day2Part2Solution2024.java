package com.cpt.adventofcode.solution.year2024.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.SlidingWindow;
import com.cpt.adventofcode.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 2, part = 2,
        description = "Red-Nosed Reports",
        link = "https://adventofcode.com/2024/day/2#part2",
        tags = "unsolved"
)
public class Day2Part2Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return Math.toIntExact(inputStream
                .map(s -> Arrays
                        .stream(s.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .filter(this::isSafeIfRemoveLevel)
                .count());
    }

    private boolean isSafe(List<Integer> levels) {
        boolean isWithinRange = SlidingWindow.of(levels, 2)
                .allMatch(integers -> {
                    int diff = Math.abs(integers.get(0) - integers.get(1));
                    return 0 < diff && diff < 4;
                });
        return (isWithinRange && (isIncreasing(levels) || isDecreasing(levels)));
    }

    private boolean isSafeIfRemoveLevel(List<Integer> levels) {
        return IntStream.range(0, levels.size())
                .anyMatch(index -> {
                    ArrayList<Integer> sublist = new ArrayList<>(levels);
                    sublist.remove(index);
                    return isSafe(sublist);
                });
    }

    private boolean isDecreasing(List<Integer> levels) {
        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) < levels.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isIncreasing(List<Integer> levels) {
        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) > levels.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
