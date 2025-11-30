package com.cpt.adventofcode.solution.year2015.day10;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 10, part = 1,
        description = "Elves Look, Elves Say",
        link = "https://adventofcode.com/2015/day/10"
)
public class Day10Part1Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        String current = inputStream.collect(Collectors.joining(""));
        for (int i = 0; i < 40; i++) {
            current = LookAndSay.iterate(current);
        }
        return current.length();
    }

}