package com.cpt.adventofcode.solution.year2015.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 6, part = 2,
        description = "Probably a Fire Hazard",
        link = "https://adventofcode.com/2015/day/6#part2",
        tags = ""
)
public class Day6Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        DimmableGrid grid = new DimmableGrid();
        inputStream
                .map(Instruction::new)
                .forEach(grid::handle);

        return grid.countOn();
    }

}