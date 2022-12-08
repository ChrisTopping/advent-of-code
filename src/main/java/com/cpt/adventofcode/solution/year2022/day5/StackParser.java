package com.cpt.adventofcode.solution.year2022.day5;

import com.google.common.base.Strings;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StackParser {

    public static Stacks parse(List<String> strings) {
        List<String> stackStrings = strings.stream()
                .takeWhile(s -> !Strings.isNullOrEmpty(s))
                .filter(s -> s.contains("["))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                            Collections.reverse(list);
                            return list;
                        })
                );
        return Stacks.fromStrings(stackStrings);
    }
}
