package com.cpt.adventofcode.solution.year2022.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 5, part = 1,
        description = "Supply Stacks",
        link = "https://adventofcode.com/2022/day/5",
        tags = ""
)
public class Day5Part1Solution2022 implements Solution<String> {

    @Override
    public String solve(Stream<String> inputStream) {
        List<String> strings = inputStream.collect(Collectors.toList());

        Stacks stacks = StackParser.parse(strings);
        Commands commands = CommandParser.parse(strings);

        Crane crane = new Crane(true);
        crane.move(commands, stacks);

        return stacks.getTopCrates();
    }

}