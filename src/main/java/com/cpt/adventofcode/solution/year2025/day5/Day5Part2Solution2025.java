package com.cpt.adventofcode.solution.year2025.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 5, part = 2,
        description = "Cafeteria",
        link = "https://adventofcode.com/2025/day/5#part2"
)
public class Day5Part2Solution2025 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        long[][] ranges = inputStream
                .filter(s -> s.contains("-"))
                .map(s -> Arrays.stream(s.split("-")).mapToLong(Long::parseLong).toArray())
                .sorted(Comparator.comparingLong(a -> a[0]))
                .toArray(long[][]::new);

        long total = 0;
        long[] current = ranges[0];

        for (int i = 1; i < ranges.length; i++) {
            long[] other = ranges[i];

            if (other[0] <= current[1] + 1) {
                current[1] = Math.max(current[1], other[1]);
            } else {
                total += current[1] - current[0] + 1;
                current = other;
                current[0] = other[0];
                current[1] = other[1];
            }
        }

        total += current[1] - current[0] + 1;

        return total;

    }

}