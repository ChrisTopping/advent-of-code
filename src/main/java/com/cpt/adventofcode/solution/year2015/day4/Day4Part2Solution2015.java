package com.cpt.adventofcode.solution.year2015.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 4, part = 2,
        description = "The Ideal Stocking Stuffer",
        link = "https://adventofcode.com/2015/day/4#part2",
        tags = ""
)
public class Day4Part2Solution2015 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        return Miner.mine(Strings.join(inputStream), 6);
    }

}