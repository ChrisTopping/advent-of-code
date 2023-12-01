package com.cpt.adventofcode.solution.year2023.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 1, part = 1,
        description = "Trebuchet?!",
        link = "https://adventofcode.com/2023/day/1",
        tags = ""
)
public class Day1Part1Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream
                .map(this::getAllDigits)
                .filter(s -> !s.isEmpty())
                .map(this::getFirstAndLastDigit)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String getAllDigits(String input) {
        return input.replaceAll("[a-z]", "");
    }

    private String getFirstAndLastDigit(String input) {
        return input.charAt(0) + "" + input.charAt(input.length() - 1);
    }

}