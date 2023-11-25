package com.cpt.adventofcode.solution.year2015.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.regex.Pattern;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 5, part = 1,
        description = "Doesn't He Have Intern-Elves For This?",
        link = "https://adventofcode.com/2015/day/5",
        tags = ""
)
public class Day5Part1Solution2015 implements Solution<Long> {

    // matches any instance of the forbidden pairs of characters
    private final Pattern forbiddenPattern = Pattern.compile("ab|cd|pq|xy");
    // matches any string with 3 vowels
    private final Pattern vowelPattern = Pattern.compile("(.*[aeiou]){3}");
    // matches any string with a pair of matching characters
    private final Pattern doublePattern = Pattern.compile("(.)\\1");

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream
                .filter(this::hasThreeVowels)
                .filter(this::containsDoubles)
                .filter(this::doesNotContainForbidden)
                .count();
    }

    private boolean hasThreeVowels(String input) {
        return vowelPattern.matcher(input).find();
    }

    private boolean containsDoubles(String input) {
        return doublePattern.matcher(input).find();
    }

    private boolean doesNotContainForbidden(String input) {
        return !forbiddenPattern.matcher(input).find();
    }

}