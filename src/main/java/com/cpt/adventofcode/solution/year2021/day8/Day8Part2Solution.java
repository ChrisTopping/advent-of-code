package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

@AdventOfCodeSolution(year = 2021, day = 8, part = 2, description = "Seven Segment Search", link = "https://adventofcode.com/2021/day/8")
public class Day8Part2Solution implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
            List<Rule> rules = asList(
                    new Rule(1, 2),
                    new Rule(4, 4),
                    new Rule(7, 3),
                    new Rule(8, 7),
                    new Rule(3, 5, 1, 2),
                    new Rule(9, 6, 4, 4),
                    new Rule(6, 6, 1, 1),
                    new Rule(5, 5, 6, 5),
                    new Rule(2, 5, 4, 2),
                    new Rule(0, 6, 5, 4)
            );

        return inputStream.map(InputOutput::new)
                .peek(inputOutput -> inputOutput.getInput().applyRulesToDigitStrings(rules))
                .mapToLong(InputOutput::getValueSums)
                .sum();
    }

    @Data
    private static class InputOutput {
        private final Input input;
        private final Output output;

        public InputOutput(String inputOutput) {
            String[] inputOutputSplit = inputOutput.split(" \\| ");
            input = new Input(stream(inputOutputSplit[0].split(" "))
                    .collect(Collectors.toList()));
            output = new Output(stream(inputOutputSplit[1].split(" "))
                    .collect(Collectors.toList()));
        }

        public long getValueSums() {
            return Long.parseLong(output.getValue(input.getDigitMap()).stream().map(String::valueOf).collect(Collectors.joining()));
        }
    }

}

