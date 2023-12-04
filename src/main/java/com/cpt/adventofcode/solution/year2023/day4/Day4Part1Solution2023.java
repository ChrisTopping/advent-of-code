package com.cpt.adventofcode.solution.year2023.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 4, part = 1,
        description = "Scratchcards",
        link = "https://adventofcode.com/2023/day/4",
        tags = ""
)
public class Day4Part1Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream
                .map(Card::new)
                .peek(Card::scratch)
                .mapToInt(Card::getScore)
                .sum();
    }

}