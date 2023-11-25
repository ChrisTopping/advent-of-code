package com.cpt.adventofcode.solution.year2022.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 6, part = 1,
        description = "Tuning Trouble",
        link = "https://adventofcode.com/2022/day/6",
        tags = ""
)
public class Day6Part1Solution2022 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        String input = inputStream.findFirst().orElse("");
        return Subroutine.findMarker(4, input);
    }

}