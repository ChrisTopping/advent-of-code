package com.cpt.adventofcode.solution.year2025.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 5, part = 1,
        description = "Cafeteria",
        link = "https://adventofcode.com/2025/day/5"
)
public class Day5Part1Solution2025 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Map<Boolean, List<String>> input = inputStream
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(s -> s.contains("-")));

        long[][] ranges = input.get(true)
                .stream()
                .map(s -> Arrays.stream(s.split("-")).mapToLong(Long::parseLong).toArray())
                .toArray(long[][]::new);

        long[] ingredients = input.get(false).stream()
                .mapToLong(Long::parseLong)
                .toArray();

        int count = 0;

        for (long ingredient : ingredients) {
            for (long[] range : ranges) {
                if (range[0] <= ingredient && range[1] >= ingredient) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

}