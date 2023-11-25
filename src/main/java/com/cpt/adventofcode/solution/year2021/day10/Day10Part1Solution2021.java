package com.cpt.adventofcode.solution.year2021.day10;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.*;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 10, part = 1,
        description = "Syntax Scoring",
        link = "https://adventofcode.com/2021/day/10",
        tags = ""
)
public class Day10Part1Solution2021 implements Solution<Long> {

    Map<String, Long> scoreMap = Map.of(")", 3L, "]", 57L, "}", 1197L, ">", 25137L);
    Map<String, String> bracketMap = Map.of("(", ")", "[", "]", "{", "}", "<", ">");

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream.map(this::toCharacterStrings)
                .mapToLong(this::solve)
                .sum();
    }

    private Long solve(List<String> brackets) {
        Stack<String> all = new Stack<>();
        Stack<String> expected = new Stack<>();
        for (String bracket : brackets) {
            if (bracketMap.containsKey(bracket)) {
                all.push(bracket);
                expected.push(bracketMap.get(bracket));
            } else {
                String closing = expected.pop();
                if (closing.equals(bracket)) {
                    all.pop();
                } else {
                    return scoreMap.get(bracket);
                }
            }
        }
        return 0L;
    }

    private List<String> toCharacterStrings(String s) {
        return new ArrayList<>(Arrays.asList(s.split("")));
    }

}