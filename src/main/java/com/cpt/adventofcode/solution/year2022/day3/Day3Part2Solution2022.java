package com.cpt.adventofcode.solution.year2022.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 3, part = 2,
        description = "Rucksack Reorganization",
        link = "https://adventofcode.com/2022/day/3#part2",
        tags = ""
)
public class Day3Part2Solution2022 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return Lists.partition(inputStream.collect(Collectors.toList()), 3).stream()
                .map(Group::new)
                .map(Group::getCommonElement)
                .mapToInt(s -> {
                    if (s.toUpperCase().equals(s)) {
                        return s.charAt(0) - 38;
                    } else {
                        return s.charAt(0) - 96;
                    }
                }).sum();
    }

    static class Group {
        List<List<String>> rucksacks;

        public Group(List<String> rucksacks) {
            this.rucksacks = rucksacks.stream()
                    .map(s -> s
                            .codePoints()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.toList())
                    ).collect(Collectors.toList());
        }

        String getCommonElement() {
            rucksacks.get(0).retainAll(rucksacks.get(1));
            rucksacks.get(0).retainAll(rucksacks.get(2));

            return rucksacks.get(0).get(0);
        }
    }

}