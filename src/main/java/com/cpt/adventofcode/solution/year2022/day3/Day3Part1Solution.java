package com.cpt.adventofcode.solution.year2022.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 3, part = 1,
        description = "Rucksack Reorganization",
        link = "https://adventofcode.com/2022/day/3",
        tags = ""
)
public class Day3Part1Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream.map(Rucksack::new)
                .map(Rucksack::getCommonElement)
                .mapToInt(s -> {
                    if (s.toUpperCase().equals(s)) {
                        return s.charAt(0) - 38;
                    } else {
                        return s.charAt(0) - 96;
                    }
                }).sum();
    }

    static class Rucksack {
        Set<String> compartmentA;
        Set<String> compartmentB;

        public Rucksack(String items) {
            int totalItems = items.length();
            compartmentA = items.substring(0, totalItems / 2).codePoints()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.toSet());
            compartmentB = items.substring(totalItems / 2).codePoints()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.toSet());
        }

        String getCommonElement() {
            compartmentA.retainAll(compartmentB);
            return compartmentA.stream().findFirst().get();
        }
    }

}