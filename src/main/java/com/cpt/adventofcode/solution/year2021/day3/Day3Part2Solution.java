package com.cpt.adventofcode.solution.year2021.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 3, part = 2,
        description = "Binary Diagnostic",
        link = "https://adventofcode.com/2021/day/3"
)
public class Day3Part2Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Report report = new Report(inputStream.collect(Collectors.toList()));
        return report.getLifeSupport();
    }

}
