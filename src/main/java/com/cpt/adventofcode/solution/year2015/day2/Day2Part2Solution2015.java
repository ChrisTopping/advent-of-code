package com.cpt.adventofcode.solution.year2015.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 2, part = 2,
        description = "v",
        link = "https://adventofcode.com/2015/day/2#part2",
        tags = ""
)
public class Day2Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream.map(s -> {
                    List<Integer> sides = Strings.splitAndCast(s, "x", Strings.Type.INTEGER);
                    return getSmallestPerimeter(sides) + getVolume(sides);
                }).mapToInt(value -> value)
                .sum();
    }

    public Integer getSmallestPerimeter(List<Integer> sides) {
        List<Integer> orderedSides = sides.stream().sorted().collect(Collectors.toList());
        return 2 * (orderedSides.get(0) + orderedSides.get(1));
    }

    public Integer getVolume(List<Integer> sides) {
        return sides.get(0) * sides.get(1) * sides.get(2);
    }

}