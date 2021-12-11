package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@AdventOfCodeSolution(
        year = 2021, day = 8, part = 2,
        description = "Seven Segment Search - Frequency Density",
        link = "https://adventofcode.com/2021/day/8"
)
public class Day8Part2FrequencyDensityAnalysisSolution implements Solution<Long> {

    private static final List<Long> FREQUENCY_DENSITIES = asList(42L, 17L, 34L, 39L, 30L, 37L, 41L, 25L, 49L, 45L);
    private static final Map<Long, Integer> FREQUENCY_DENSITY_MAP = IntStream.range(0, 10)
            .boxed()
            .collect(Collectors.toMap(FREQUENCY_DENSITIES::get, Function.identity()));

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream.mapToLong(this::solve).sum();
    }

    private Long solve(String line) {
        String[] inputOutput = line.split(" \\| ");
        return Long.parseLong(getDigitString(inputOutput[1], calculateFrequencyMap(inputOutput[0])));
    }

    private Map<String, Long> calculateFrequencyMap(String input) {
        return Arrays.stream(input.split(""))
                .filter(s -> !s.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private String getDigitString(String s1, Map<String, Long> frequencyMap) {
        return Arrays.stream(s1.split(" "))
                .mapToLong(s -> getFrequencyDensityForCharacters(frequencyMap, s))
                .map(FREQUENCY_DENSITY_MAP::get)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    private long getFrequencyDensityForCharacters(Map<String, Long> frequencyMap, String characters) {
        return Arrays.stream(characters.split(""))
                .mapToLong(frequencyMap::get)
                .sum();
    }

}
