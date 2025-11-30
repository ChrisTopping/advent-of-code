package com.cpt.adventofcode.solution.year2015.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LookAndSay {

    public static String iterate(String input) {
        List<List<Character>> parts = new ArrayList<>();
        for (int i = 0; i <= input.length() - 1; i++) {
            if (!parts.isEmpty() && parts.getLast().getFirst().equals(input.charAt(i))) {
                parts.getLast().add(input.charAt(i));
            } else {
                ArrayList<Character> nextPart = new ArrayList<>();
                nextPart.add(input.charAt(i));
                parts.add(nextPart);
            }
        }
        return parts.stream()
                .map(integers -> "%d%s".formatted(integers.size(), integers.getFirst()))
                .collect(Collectors.joining(""));
    }

}
