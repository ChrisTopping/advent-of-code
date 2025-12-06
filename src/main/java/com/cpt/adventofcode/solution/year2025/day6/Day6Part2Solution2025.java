package com.cpt.adventofcode.solution.year2025.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 6, part = 2,
        description = "Trash Compactor",
        link = "https://adventofcode.com/2025/day/6#part2"
)
public class Day6Part2Solution2025 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        String[] input = inputStream.toArray(String[]::new);

        long answer = 0;

        char operation = ' ';
        long currentAnswer = 0;
        
        for (int col = 0; col < input[0].length(); col++) {
            char operationAtCurrentCol = input[input.length - 1].charAt(col);
            if (operationAtCurrentCol != ' ') {
                operation = operationAtCurrentCol;
                answer += currentAnswer;
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

        answer += currentAnswer;

        return answer;
    }

}