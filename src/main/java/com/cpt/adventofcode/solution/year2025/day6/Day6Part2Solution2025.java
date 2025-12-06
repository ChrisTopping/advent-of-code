package com.cpt.adventofcode.solution.year2025.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 6, part = 2,
        description = "Trash Compactor",
        link = "https://adventofcode.com/2025/day/6#part2"
)
public class Day6Part2Solution2025 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        String[] input = inputStream.toArray(String[]::new);

        String[] operations = input[input.length - 1].split("\\s+");
        long[] answers = new long[operations.length];

        char operation = ' ';
        int questionNumber = -1;
        long currentAnswer = 0;
        for (int col = 0; col < input[0].length(); col++) {
            char operationAtCurrentCol = input[input.length - 1].charAt(col);
            if (operationAtCurrentCol != ' ') {
                questionNumber++;
                operation = operationAtCurrentCol;
                answers[Math.max(questionNumber - 1, 0)] = currentAnswer;
                currentAnswer = operation == '*' ? 1 : 0;
            }
            StringBuilder currentNumber = new StringBuilder();
            for (int row = 0; row < input.length - 1; row++) {
                currentNumber.append(Character.toString(input[row].charAt(col)).strip());
            }

            if (!currentNumber.toString().isEmpty()) {
                currentAnswer = operation == '*'
                        ? currentAnswer * Integer.parseInt(currentNumber.toString())
                        : currentAnswer + Integer.parseInt(currentNumber.toString());
            }
        }

        answers[questionNumber] = currentAnswer;

        return Arrays.stream(answers).sum();
    }

}