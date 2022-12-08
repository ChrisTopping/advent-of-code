package com.cpt.adventofcode.solution.year2022.day6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Subroutine {

    public static Integer findMarker(int markerLength, String buffer) {
        List<String> inputList = Arrays.stream(buffer.split(""))
                .collect(Collectors.toList());

        for (int i = 0; i < inputList.size() - markerLength + 1; i++) {
            List<String> sublist = inputList.subList(i, i + markerLength);
            if (new HashSet<String>(sublist).size() == markerLength) {
                return i + markerLength;
            }
        }
        throw new RuntimeException("Failed to find four unique characters");
    }
}
