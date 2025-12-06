package com.cpt.adventofcode.solution.year2025.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 6, part = 1,
        description = "Trash Compactor",
        link = "https://adventofcode.com/2025/day/6"
)
public class Day6Part1Solution2025 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        String[][] input = inputStream
                .map(String::trim)
                .map(s -> s.split("\\s+"))
                .toArray(String[][]::new);

        String[][] questions = Arrays.copyOfRange(input, 0, input.length - 1);
        String[] operations = input[input.length - 1];

        long[] answers = new long[questions[0].length];
        for (int i = 0; i < questions[0].length; i++) {
            answers[i] = operations[i].equals("+") ? 0 : 1;
        }

        for (String[] question : questions) {
            for (int col = 0; col < question.length; col++) {
                answers[col] = switch (operations[col]) {
                    case "+" -> answers[col] + Integer.parseInt(question[col]);
                    case "*" -> answers[col] * Integer.parseInt(question[col]);
                    default -> throw new IllegalStateException("Unexpected value: " + operations[col]);
                };
            }
        }
        return Arrays.stream(answers).sum();
    }

}