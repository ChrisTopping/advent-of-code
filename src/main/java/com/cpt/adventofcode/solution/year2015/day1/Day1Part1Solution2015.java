package com.cpt.adventofcode.solution.year2015.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 1, part = 1,
        description = "Not Quite Lisp",
        link = "https://adventofcode.com/2015/day/1",
        tags = ""
)
public class Day1Part1Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        String input = inputStream.collect(Collectors.joining(""));
        Map<String, List<String>> stringMap = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(s -> s));

        return stringMap.get("(").size() - stringMap.get(")").size();
    }

}