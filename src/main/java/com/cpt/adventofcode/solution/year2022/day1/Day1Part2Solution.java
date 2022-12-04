package com.cpt.adventofcode.solution.year2022.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 1, part = 2,
        description = "Calorie Counter",
        link = "https://adventofcode.com/2022/day/1#part2",
        tags = ""
)
public class Day1Part2Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<Integer> sums = CalorieCalculator.calculate(inputStream);
        return sums.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(value -> value)
                .sum();
    }

}