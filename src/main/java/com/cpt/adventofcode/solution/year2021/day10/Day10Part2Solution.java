package com.cpt.adventofcode.solution.year2021.day10;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 10, part = 2,
        description = "Syntax Scoring",
        link = "https://adventofcode.com/2021/day/10",
        tags = ""
)
public class Day10Part2Solution implements Solution<Long> {

    Map<String, Long> scoreMap = Map.of(")", 1L, "]", 2L, "}", 3L, ">", 4L);
    Map<String, String> bracketMap = Map.of("(", ")", "[", "]", "{", "}", "<", ">");

    @Override
    public Long solve(Stream<String> inputStream) {
        List<List<String>> collect = inputStream.map(this::toCharacterStrings)
                .filter(this::isIncomplete).collect(Collectors.toList());

        List<Long> scores = collect.stream()
                .map(this::getIncompleteScore)
                .sorted()
                .collect(Collectors.toList());

        return scores.get((scores.size() - 1)/2);
    }

    private long getIncompleteScore(List<String> brackets) {
        LinkedList<String> all = new LinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        for (String bracket : brackets) {
            if (bracketMap.containsKey(bracket)) {
                all.push(bracket);
                expected.push(bracketMap.get(bracket));
            } else {
                String closing = expected.pop();
                if (closing.equals(bracket)) {
                    all.pop();
                }
            }
        }

        long sum = 0;
        while (!expected.isEmpty()) {
            sum  = sum * 5 + scoreMap.get(expected.pollFirst());
        }

        return sum;
    }

    private boolean isIncomplete(List<String> brackets) {
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
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> toCharacterStrings(String s) {
        int length = s.length();
        List<String> strings = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            strings.add(String.valueOf(s.charAt(i)));
        }
        return strings;
    }

}