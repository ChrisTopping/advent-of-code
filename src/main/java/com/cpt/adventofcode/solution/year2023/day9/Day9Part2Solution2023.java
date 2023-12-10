package com.cpt.adventofcode.solution.year2023.day9;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.SlidingWindow;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 9, part = 2,
        description = "Mirage Maintenance",
        link = "https://adventofcode.com/2023/day/9#part2",
        tags = ""
)
public class Day9Part2Solution2023 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream.map(s -> Arrays.stream(s.split("\\s+")).map(Long::parseLong).collect(Collectors.toList()))
                .mapToLong(this::extrapolate)
                .sum();
    }

    private long extrapolate(List<Long> sequence) {
        if (sequence.stream().allMatch(value -> value == 0)) {
            return 0;
        }

        return sequence.get(0) - extrapolate(differences(sequence));
    }

    private List<Long> differences(List<Long> sequence) {
        return SlidingWindow.of(sequence, 2)
                .map(longs -> longs.get(1) - longs.get(0))
                .collect(Collectors.toList());
    }

}