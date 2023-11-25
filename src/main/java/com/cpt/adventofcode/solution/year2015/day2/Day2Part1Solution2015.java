package com.cpt.adventofcode.solution.year2015.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 2, part = 1,
        description = "I Was Told There Would Be No Math",
        link = "https://adventofcode.com/2015/day/2",
        tags = ""
)
public class Day2Part1Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream.map(s -> {
                    List<Integer> integers = Strings.splitAndCast(s, "x", Strings.Type.INTEGER);
                    Integer l = integers.get(0);
                    Integer w = integers.get(1);
                    Integer h = integers.get(2);

                    List<Integer> sides = List.of(2 * l * w, 2 * w * h, 2 * h * l);
                    return sides.stream().mapToInt(value -> value).sum() + sides.stream().mapToInt(value -> value).min().orElse(0) / 2;
                }).mapToInt(value -> value)
                .sum();
    }

}