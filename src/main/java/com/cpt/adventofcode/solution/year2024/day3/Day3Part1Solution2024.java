package com.cpt.adventofcode.solution.year2024.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.collect.Streams;

import java.util.Map;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 3, part = 1,
        description = "Mull It Over",
        link = "https://adventofcode.com/2024/day/3"
)
public class Day3Part1Solution2024 implements Solution<Integer> {

    private static final String MUL_PATTERN = "(mul)\\((?<left>\\d+),(?<right>\\d+)\\)";

    private static final String LEFT_KEY = "left";
    private static final String RIGHT_KEY = "right";

    private static final Strings.ItemMatcher MULTIPLIER_ITEM_MATCHER = new Strings.ItemMatcher(MUL_PATTERN, Map.of(LEFT_KEY, Strings.Type.LONG, RIGHT_KEY, Strings.Type.LONG));

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream.map(s -> Strings.parseAll(s, MULTIPLIER_ITEM_MATCHER))
                .mapToInt(value -> Streams
                        .zip(value.get(LEFT_KEY).stream(), value.get(RIGHT_KEY).stream(), (o, o2) -> Integer.parseInt(o.toString()) * Integer.parseInt(o2.toString()))
                        .mapToInt(v -> v)
                        .sum()).sum();
    }

}