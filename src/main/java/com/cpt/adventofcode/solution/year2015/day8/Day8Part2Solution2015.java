package com.cpt.adventofcode.solution.year2015.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 8, part = 2,
        description = "Matchsticks",
        link = "https://adventofcode.com/2015/day/8#part2"
)
public class Day8Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> input = inputStream.toList();
        String encoded = encode(input);
        int encodedLength = encoded.length();
        int inputLength = input.stream().mapToInt(String::length).sum();
        return encodedLength - inputLength;
    }

    static String encode(List<String> input) {
        return input.stream().map(Day8Part2Solution2015::encode).collect(Collectors.joining(""));
    }

    static String encode(String input) {
        return "\"" + input
                .replaceAll("\\\\", "\\\\\\\\")
                .replaceAll("\"", "\\\\\"") + "\"";
    }

}