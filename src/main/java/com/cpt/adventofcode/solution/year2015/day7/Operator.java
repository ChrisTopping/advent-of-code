package com.cpt.adventofcode.solution.year2015.day7;

import lombok.Getter;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Operator {
    AND("(\\w+) AND (\\w+)", (first, second) -> (first & second) & 0xFFFF),
    OR("(\\w+) OR (\\w+)", (first, second) -> (first | second) & 0xFFFF),
    LSHIFT("(\\w+) LSHIFT (\\w+)", (first, second) -> (first << second) & 0xFFFF),
    RSHIFT("(\\w+) RSHIFT (\\w+)", (first, second) -> (first >> second) & 0xFFFF),
    NOT("NOT (\\w+)", (first, _) -> ~first & 0xFFFF),
    SET("(\\w+)", (first, _) -> first);

    @Getter
    private final Pattern pattern;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String pattern, BiFunction<Integer, Integer, Integer> function) {
        this.pattern = Pattern.compile(pattern);
        this.function = function;
    }

    public static Operator fromOperation(String operation) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.pattern.matcher(operation).matches())
                .findFirst()
                .orElseThrow();
    }

    public String[] getOperands(String operation) {
        Matcher matcher = pattern.matcher(operation);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        return switch (this) {
            case AND, OR, LSHIFT, RSHIFT -> new String[]{matcher.group(1), matcher.group(2)};
            case NOT, SET -> new String[]{matcher.group(1)};
        };
    }

    public int apply(int first, int second) {
        return function.apply(first, second);
    }

}
