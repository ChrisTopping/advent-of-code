package com.cpt.adventofcode.solution.year2015.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 8, part = 1,
        description = "Matchsticks",
        link = "https://adventofcode.com/2015/day/8"
)
public class Day8Part1Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> input = inputStream.toList();
        String escaped = escape(input);
        int escapedLength = escaped.length();
        int inputLength = input.stream().mapToInt(String::length).sum();
        return inputLength - escapedLength;
    }

    static String escape(List<String> input) {
        return input.stream().map(Day8Part1Solution2015::escape).collect(Collectors.joining(""));
    }

    static String escape(String input) {
        return input.substring(1, input.length() - 1)
                .replaceAll("\\\\\\\\", "\\\\")
                .replaceAll("\\\\x[0-9A-Fa-f]{2}", "#")
                .replaceAll("\\\\\"", "\"");
    }

}