package com.cpt.adventofcode.solution.year2023.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Comparator;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 3, part = 1,
        description = "Gear Ratios",
        link = "https://adventofcode.com/2023/day/3",
        tags = ""
)
public class Day3Part1Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Grid grid = new Grid(inputStream);

        grid.getNumbers().forEach(number -> grid.getSymbols().forEach(number::visit));

        return grid.getNumbers().stream()
                .filter(Number::isSerialNumber)
                .sorted(Comparator.comparing(Number::getY))
                .mapToInt(Number::getNumber)
                .sum();
    }

}