package com.cpt.adventofcode.solution.year2015.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 6, part = 1,
        description = "Probably a Fire Hazard",
        link = "https://adventofcode.com/2015/day/6",
        tags = ""
)
public class Day6Part1Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Grid grid = new Grid();
        inputStream
                .map(Instruction::new)
                .forEach(grid::handle);

        return grid.countOn();
    }

}