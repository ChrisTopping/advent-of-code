package com.cpt.adventofcode.solution.year2022.day1;

import com.cpt.adventofcode.solution.year2021.day1.SlidingWindow;
import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CalorieCalculator {

    public static List<Integer> calculate(Stream<String> inputStream) {
        List<Integer> input = inputStream
                .map(s -> Strings.isNullOrEmpty(s) ? "0" : s)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int[] delimiterIndices = IntStream.range(0, input.size())
                .filter(value -> input.get(value) == 0 || value == 0 || value == input.size() - 1)
                .toArray();

        return SlidingWindow.of(Arrays.stream(delimiterIndices).boxed().collect(Collectors.toList()), 2)
                .map(indices -> input.subList(indices.get(0), indices.get(1) + 1))
                .map(calories -> calories.stream().mapToInt(value -> value).sum())
                .collect(Collectors.toList());
    }

}
