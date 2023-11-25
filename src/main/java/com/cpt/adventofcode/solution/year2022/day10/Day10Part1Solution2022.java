package com.cpt.adventofcode.solution.year2022.day10;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 10, part = 1,
        description = "Cathode-Ray Tube",
        link = "https://adventofcode.com/2022/day/10",
        tags = ""
)
public class Day10Part1Solution2022 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        Register register = Register.initialise(inputStream);
        return register.calculateSignalStrength(20, 40);
    }

}