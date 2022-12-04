package com.cpt.adventofcode.solution.year2022.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 4, part = 2,
        description = "Camp Cleanup",
        link = "https://adventofcode.com/2022/day/4#part2",
        tags = ""
)
public class Day4Part2Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return (int) inputStream
                .map(Pair::new)
                .filter(pair -> {
                    Assignment first = pair.getFirst();
                    Assignment second = pair.getSecond();
                    return first.intersectsWith(second) || second.intersectsWith(first);
                }).count();
    }



}