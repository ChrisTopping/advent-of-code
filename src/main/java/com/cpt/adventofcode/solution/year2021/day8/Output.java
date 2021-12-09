package com.cpt.adventofcode.solution.year2021.day8;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
@Data
public class Output {

    private final List<String> digitsStrings;

    public List<Integer> getValue(Map<Integer, String> digitMap) {
        Map<String, Integer> invertedDigitMap = digitMap.entrySet().stream()
                .collect(Collectors.toMap(integerStringEntry -> alphabetical(integerStringEntry.getValue()), Map.Entry::getKey));

        return digitsStrings.stream()
                .map(this::alphabetical)
                .map(invertedDigitMap::get)
                .collect(Collectors.toList());
    }

    private String alphabetical(String string) {
        return stream(string.split(""))
                .sorted()
                .collect(Collectors.joining());
    }

}
