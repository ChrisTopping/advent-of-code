package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@AdventOfCodeSolution(
        year = 2021, day = 8, part = 1,
        description = "Seven Segment Search",
        link = "https://adventofcode.com/2021/day/8"
)
public class Day8Part1Solution implements Solution<Long> {

    private static final List<Integer> uniques = asList(2, 4, 3, 7);

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream
                .map(s -> s.split(" \\| ")[1])
                .map(s -> s.split(" "))
                .flatMap(Stream::of)
                .map(s -> s.split(""))
                .map(s -> s.length)
                .filter(Day8Part1Solution.uniques::contains)
                .count();
    }
}
