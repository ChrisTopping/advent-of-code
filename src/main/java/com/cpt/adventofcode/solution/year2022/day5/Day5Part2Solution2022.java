package com.cpt.adventofcode.solution.year2022.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 5, part = 2,
        description = "Supply Stacks",
        link = "https://adventofcode.com/2022/day/5#part2",
        tags = ""
)
public class Day5Part2Solution2022 implements Solution<String> {

    @Override
    public String solve(Stream<String> inputStream) {
        List<String> strings = inputStream.collect(Collectors.toList());

        Stacks stacks = StackParser.parse(strings);
        Commands commands = CommandParser.parse(strings);

        Crane crane = new Crane(false);
        crane.move(commands, stacks);

        return stacks.getTopCrates();
    }

}