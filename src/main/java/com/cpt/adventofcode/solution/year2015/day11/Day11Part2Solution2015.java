package com.cpt.adventofcode.solution.year2015.day11;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 11, part = 2,
        description = "Corporate Policy",
        link = "https://adventofcode.com/2015/day/11#part2"
)
public class Day11Part2Solution2015 implements Solution<String> {

    @Override
    public String solve(Stream<String> inputStream) {
        String current = inputStream.collect(Collectors.joining(""));
        return PasswordIncrementor.getNextValid(PasswordIncrementor.getNextValid(current));
    }

}