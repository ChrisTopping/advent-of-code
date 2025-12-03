package com.cpt.adventofcode.solution.year2025.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.base.Strings;
import com.google.common.collect.Streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 2, part = 1,
        description = "Gift Shop - Less Brute Force",
        link = "https://adventofcode.com/2025/day/2"
)
public class Day2Part1Solution2025LessBruteForce implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        return Arrays.stream(inputStream.collect(Collectors.joining("")).split(","))
                .map(s -> s.split("-"))
                .flatMapToLong(s -> getInvalidIds(s[0], s[1]))
                .sum();
    }

    private LongStream getInvalidIds(String lowerString, String upperString) {
        int lowerDigits = lowerString.length();
        int upperDigits = upperString.length();

        if (lowerDigits != upperDigits) {
            String boundary = Strings.repeat("9", lowerDigits);
            return Streams.concat(
                    getInvalidIds(lowerString, boundary),
                    getInvalidIds(String.valueOf(Long.parseLong(boundary) + 1), upperString)
            );
        }

        if (lowerDigits % 2 != 0) {
            return LongStream.empty();
        }

        String lowerHalf = lowerString.substring(0, lowerDigits / 2);
        String upperHalf = upperString.substring(0, upperDigits / 2);

        long lower = Long.parseLong(lowerString);
        long upper = Long.parseLong(upperString);

        return LongStream.rangeClosed(Long.parseLong(lowerHalf), Long.parseLong(upperHalf))
                .map(v -> v * (long) Math.pow(10, lowerDigits/2) + v)
                .filter(value -> value >= lower)
                .filter(value -> value <= upper);
    }

}