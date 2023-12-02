package com.cpt.adventofcode.solution.year2023.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 2, part = 2,
        description = "Cube Conundrum",
        link = "https://adventofcode.com/2023/day/2#part2",
        tags = ""
)
public class Day2Part2Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream
                .map(Game::new)
                .mapToInt(Game::calculatePower)
                .sum();
    }

}