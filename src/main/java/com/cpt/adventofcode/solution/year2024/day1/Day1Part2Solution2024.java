package com.cpt.adventofcode.solution.year2024.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 1, part = 2,
        description = "Historian Hysteria",
        link = "https://adventofcode.com/2024/day/1#part2",
        tags = "unsolved"
)
public class Day1Part2Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<int[]> numberArray = inputStream.map(s -> s.split("\\s+"))
                .map(strings -> new int[]{Integer.parseInt(strings[0]), Integer.parseInt(strings[1])})
                .collect(Collectors.toList());

        Map<Integer, Integer> countMap = new HashMap<>();

        numberArray.stream().mapToInt(ints -> ints[1])
                .forEach(value -> {
                    Integer count = countMap.getOrDefault(value, 0) + 1;
                    countMap.put(value, count);
                });


       return numberArray.stream().mapToInt(ints -> ints[0])
                .map(operand -> operand * countMap.getOrDefault(operand, 0))
                .sum();
    }

}