package com.cpt.adventofcode.solution.year2023.day3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
class Line {
    private static final Pattern numberPattern = Pattern.compile("[0-9]+");
    private static final Pattern symbolPattern = Pattern.compile("[^0-9\\.]");

    private final List<Number> numbers = new ArrayList<>();
    private final List<Symbol> symbols = new ArrayList<>();

    public Line(String input, int y) {
        buildNumbers(input, y);
        buildSymbols(input, y);
    }

    private void buildNumbers(String input, int y) {
        Matcher numberMatcher = numberPattern.matcher(input);
        boolean hasNumbers = true;
        while (hasNumbers) {
            if (numberMatcher.find()) {
                int start = numberMatcher.start();
                int end = numberMatcher.end() - 1;
                Number number = new Number(Integer.parseInt(numberMatcher.group(0)), start, end, y);
                numbers.add(number);
            } else {
                hasNumbers = false;
            }
        }
    }

    private void buildSymbols(String input, int y) {
        Matcher symbolMatcher = symbolPattern.matcher(input);
        boolean hasSymbols = true;
        while (hasSymbols) {
            if (symbolMatcher.find()) {
                int position = symbolMatcher.start();
                symbols.add(new Symbol(position, y, symbolMatcher.group(0)));
            } else {
                hasSymbols = false;
            }
        }
    }
}
