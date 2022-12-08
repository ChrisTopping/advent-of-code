package com.cpt.adventofcode.solution.year2022.day5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Getter
@RequiredArgsConstructor
public class Command {
    private static final Pattern PATTERN = Pattern.compile(".*\\s(\\d+).*\\s(\\d+).*\\s(\\d+)");
    private final int count;
    private final int from;
    private final int to;

    public static Command fromString(String commandString) {
        Matcher matcher = PATTERN.matcher(commandString);
        matcher.find();
        int count = Integer.parseInt(matcher.group(1));
        int from = Integer.parseInt(matcher.group(2)) - 1;
        int to = Integer.parseInt(matcher.group(3)) - 1;
        return new Command(count, from, to);
    }


}
