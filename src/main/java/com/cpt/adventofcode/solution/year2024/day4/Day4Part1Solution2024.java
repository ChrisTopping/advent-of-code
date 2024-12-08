package com.cpt.adventofcode.solution.year2024.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 4, part = 1,
        description = "Ceres Search",
        link = "https://adventofcode.com/2024/day/4",
        tags = "unsolved"
)
public class Day4Part1Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {


        String[][] thing = inputStream.map(s -> s.split(""))
                .toArray(String[][]::new);
        return 0;
    }


}