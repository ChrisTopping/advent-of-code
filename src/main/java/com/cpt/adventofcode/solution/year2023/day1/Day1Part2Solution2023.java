package com.cpt.adventofcode.solution.year2023.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Map;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 1, part = 2,
        description = "Trebuchet?!",
        link = "https://adventofcode.com/2023/day/1#part2",
        tags = ""
)
public class Day1Part2Solution2023 implements Solution<Integer> {

    // replace written numbers with digits but maintain single-letter overlap with adjacent written numbers
    private final Map<String, String> digitMap = Map.of(
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    );

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream
                .map(this::replaceWrittenDigits)
                .map(this::getAllDigits)
                .filter(s -> !s.isEmpty())
                .map(this::getFirstAndLastDigit)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String replaceWrittenDigits(String input) {
        for (Map.Entry<String, String> entry : digitMap.entrySet()) {
            input = input.replaceAll(entry.getKey(), entry.getValue());
        }
        return input;
    }

    private String getAllDigits(String input) {
        return input.replaceAll("[a-z]", "");
    }

    private String getFirstAndLastDigit(String input) {
        return input.charAt(0) + "" + input.charAt(input.length() - 1);
    }

}