package com.cpt.adventofcode.solution.year2015.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.security.MessageDigest;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 4, part = 1,
        description = "The Ideal Stocking Stuffer",
        link = "https://adventofcode.com/2015/day/4",
        tags = ""
)
public class Day4Part1Solution2015 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        return Miner.mine(Strings.join(inputStream), 5);
    }

}