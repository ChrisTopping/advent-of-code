package com.cpt.adventofcode.solution.year2023.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 3, part = 2,
        description = "Gear Ratios",
        link = "https://adventofcode.com/2023/day/3#part2",
        tags = ""
)
public class Day3Part2Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Grid grid = new Grid(inputStream);

        grid.getNumbers().forEach(number -> grid.getSymbols().forEach(number::visit));

        return grid.getSymbols().stream()
                .mapToInt(Symbol::getGearRatio)
                .sum();
    }

}