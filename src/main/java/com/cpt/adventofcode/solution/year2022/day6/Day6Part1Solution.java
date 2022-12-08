package com.cpt.adventofcode.solution.year2022.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.cpt.adventofcode.solution.year2021.day1.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 6, part = 1,
        description = "Tuning Trouble",
        link = "https://adventofcode.com/2022/day/6",
        tags = ""
)
public class Day6Part1Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        String input = inputStream.findFirst().orElse("");
        return Subroutine.findMarker(4, input);
    }

}