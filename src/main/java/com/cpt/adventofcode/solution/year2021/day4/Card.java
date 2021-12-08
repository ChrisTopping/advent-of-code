package com.cpt.adventofcode.solution.year2021.day4;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Card {

    private final long rowSize;
    private final long columnSize;
    private final Map<Integer, Coordinate> numberCoordinateMap = new HashMap<>();
    private final Map<Coordinate, Boolean> coordinateBooleanMap = new HashMap<>();

    public void addRow(String rowString, int rowIndex) {
        int[] row = Arrays.stream(rowString.strip().split("\\s+"))
                .map(String::strip)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
            Coordinate coordinate = new Coordinate(rowIndex, columnIndex);
            numberCoordinateMap.put(row[columnIndex], coordinate);
            coordinateBooleanMap.put(coordinate, false);
        }
    }

    public void callNumber(int number) {
        Coordinate coordinate = numberCoordinateMap.get(number);
        if (coordinate != null) {
            coordinateBooleanMap.put(coordinate, true);
        }
    }

    public boolean isWinning() {
        List<Map.Entry<Coordinate, Boolean>> trueEntries = coordinateBooleanMap.entrySet().stream()
                .filter(Map.Entry::getValue)
                .collect(Collectors.toList());

        Map<Integer, Long> rowCount = trueEntries.stream()
                .map(entry -> entry.getKey().getRow())
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()));

        Map<Integer, Long> columnCount = trueEntries.stream()
                .map(entry -> entry.getKey().getColumn())
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()));

        return rowCount.containsValue(rowSize) || columnCount.containsValue(columnSize);
    }

    public int sumUncalledNumbers() {
        return numberCoordinateMap.entrySet().stream()
                .filter(entry -> !coordinateBooleanMap.get(entry.getValue()))
                .mapToInt(Map.Entry::getKey)
                .sum();
    }

    @RequiredArgsConstructor
    @EqualsAndHashCode
    @Data
    private static class Coordinate {
        private final int row;
        private final int column;
    }

}
