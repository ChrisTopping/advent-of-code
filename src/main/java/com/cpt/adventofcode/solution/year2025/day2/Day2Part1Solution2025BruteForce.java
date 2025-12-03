package com.cpt.adventofcode.solution.year2025.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 2, part = 1,
        description = "Gift Shop - Brute Force",
        link = "https://adventofcode.com/2025/day/2"
)
public class Day2Part1Solution2025BruteForce implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        return Arrays.stream(inputStream.collect(Collectors.joining("")).split(","))
                .toList().stream()
                .map(s -> s.split("-"))
                .filter(s -> s[0].length() != s[1].length() || s[0].length() % 2 == 0)
                .flatMapToLong(strings -> LongStream.range(Long.parseLong(strings[0]), Long.parseLong(strings[1]) + 1))
                .filter(this::isInvalid)
                .sum();
    }

    private boolean isInvalid(long i) {
        return String.valueOf(i).matches("(\\d+)\\1");
    }

}