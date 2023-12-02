package com.cpt.adventofcode.solution.year2023.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 2, part = 1,
        description = "Cube Conundrum",
        link = "https://adventofcode.com/2023/day/2",
        tags = ""
)
public class Day2Part1Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream
                .map(Game::new)
                .filter(game -> game.isLegal(14, 13, 12))
                .mapToInt(Game::getId)
                .sum();
    }

}