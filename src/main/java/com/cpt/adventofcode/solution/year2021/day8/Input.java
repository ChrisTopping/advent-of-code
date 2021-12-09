package com.cpt.adventofcode.solution.year2021.day8;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
@Data
public class Input {

    private final List<String> digitStrings;
    private final Map<Integer, String> digitMap = new HashMap<>();

    public void applyRulesToDigitStrings(List<Rule> rules) {
        rules.forEach(rule -> digitStrings.forEach(chars -> rule.check(chars, this)));
    }

    boolean intersects(String s, int digit, int intersections) {
        Set<String> chars = new HashSet<>(chars(s));
        int size = chars.size();
        chars(digitMap.get(digit)).forEach(chars::remove);
        return chars.size() == size - intersections;
    }

    String set(int i, String s) {
        return digitMap.put(i, s);
    }

    private List<String> chars(String charsString) {
        return Arrays.asList(charsString.split(""));
    }

    boolean length(String chars, int length) {
        return chars.split("").length == length;
    }

}
