package com.cpt.adventofcode.solution.year2024.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.collect.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 1, part = 1,
        description = "Historian Hysteria",
        link = "https://adventofcode.com/2024/day/1",
        tags = "unsolved"
)
public class Day1Part1Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<int[]> numberArray = inputStream.map(s -> s.split("\\s+"))
                .map(strings -> new int[]{Integer.parseInt(strings[0]), Integer.parseInt(strings[1])})
                .collect(Collectors.toList());

        int[] first = numberArray.stream().mapToInt(ints -> ints[0])
                .sorted()
                .toArray();

        int[] second = numberArray.stream().mapToInt(ints -> ints[1])
                .sorted()
                .toArray();

        return IntStream.range(0, first.length)
                .map(i -> Math.abs(first[i] - second[i]))
                .sum();
    }

}