package com.cpt.adventofcode.solution.year2022.day5;

import com.google.common.base.Strings;

import java.util.List;
import java.util.stream.Collectors;

public class CommandParser {

    public static Commands parse(List<String> strings) {
        List<String> commandStrings = strings.stream()
                .dropWhile(s -> !Strings.isNullOrEmpty(s))
                .skip(1)
                .collect(Collectors.toList());
        return Commands.fromStrings(commandStrings);
    }
}
