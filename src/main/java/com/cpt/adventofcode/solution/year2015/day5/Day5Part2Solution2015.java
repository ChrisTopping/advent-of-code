package com.cpt.adventofcode.solution.year2015.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.SlidingWindow;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 5, part = 2,
        description = "Doesn't He Have Intern-Elves For This?",
        link = "https://adventofcode.com/2015/day/5#part2",
        tags = ""
)
public class Day5Part2Solution2015 implements Solution<Long> {

    Pattern doublePairsPattern = Pattern.compile("(..).*\\1");
    Pattern palindromePattern = Pattern.compile("(.).\\1");

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream
                .filter(this::hasDoublePairs)
                .filter(this::hasThreeLetterPalindrome)
                .count();
    }

    private boolean hasDoublePairs(String input) {
        return doublePairsPattern.matcher(input).find();
    }

    private boolean hasThreeLetterPalindrome(String input) {
        return palindromePattern.matcher(input).find();
    }

}