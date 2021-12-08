package com.cpt.adventofcode.solution.year2021.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Report {

    private final int rowCount;
    private final int columnCount;
    private final int[][] binary;

    public Report(List<String> rows) {
        this.rowCount = rows.size();
        this.columnCount = rows.get(0).length();
        binary = new int[rowCount][columnCount];

        for (int r = 0; r < rowCount; r++) {
            binary[r] = Arrays.stream(rows.get(r).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    public int getPowerConsumption() {
        int[] gamma = getGamma();
        int[] epsilon = invert(gamma);
        return toDecimal(gamma) * toDecimal(epsilon);
    }

    private int[] getGamma() {
        int[] gamma = new int[columnCount];
        for (int column = 0; column < columnCount; column++) {
            gamma[column] = getMostCommonForRow(binary, column);
        }
        return gamma;
    }

    public int getLifeSupport() {
        return toDecimal(getOxygenGenerator()) * toDecimal(getC02Scrubber());
    }

    private int[] getOxygenGenerator() {
        int[][] oxygenGenerator = copy(binary);

        for (int column = 0; column < columnCount; column++) {
            int mostCommonInOxygenGenerator = getMostCommonForRow(oxygenGenerator, column);
            oxygenGenerator = filterOxygenGenerator(oxygenGenerator, column, mostCommonInOxygenGenerator);
            if (oxygenGenerator.length == 1) {
                return oxygenGenerator[0];
            }
        }

        throw new RuntimeException("Could not determine the life support coefficient");
    }

    private int[][] filterOxygenGenerator(int[][] oxygenGenerator, int finalColumn, int mostCommonInOxygenGenerator) {
        return Arrays.stream(oxygenGenerator)
                .filter(row -> row[finalColumn] == mostCommonInOxygenGenerator)
                .toArray(int[][]::new);
    }

    private int[] getC02Scrubber() {
        int[][] c02Scrubber = copy(binary);

        for (int column = 0; column < columnCount; column++) {
            int mostCommonInC02Scrubber = getMostCommonForRow(c02Scrubber, column);
            c02Scrubber = filterC02Scrubber(c02Scrubber, column, mostCommonInC02Scrubber);
            if (c02Scrubber.length <= 1) {
                return c02Scrubber[0];
            }
        }

        throw new RuntimeException("Could not determine the life support coefficient");
    }

    private int[][] filterC02Scrubber(int[][] c02Scrubber, int finalColumn, int mostCommonInC02Scrubber) {
        return Arrays.stream(c02Scrubber)
                .filter(row -> row[finalColumn] != mostCommonInC02Scrubber)
                .toArray(int[][]::new);
    }

    private int getMostCommonForRow(int[][] array, int r) {
        final int row = r;
        int sum = Arrays.stream(array)
                .mapToInt(operand -> operand[row])
                .sum();
        return (sum >= array.length / 2f) ? 1 : 0;
    }

    private int[][] copy(int[][] original) {
        return Arrays.stream(original)
                .map(a -> Arrays.copyOf(a, a.length))
                .toArray(int[][]::new);
    }

    private int toDecimal(int[] binary) {
        String combined = Arrays.stream(binary)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(combined, 2);
    }

    private int[] invert(int[] binary) {
        return Arrays.stream(binary)
                .map(operand -> operand == 0 ? 1 : 0)
                .toArray();
    }
}
