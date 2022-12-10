package com.cpt.adventofcode.solution.year2022.day8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Matrix<T> {
    private List<List<T>> inner = new ArrayList<>();

    public void addRow(List<T> row) {
        inner.add(row);
    }

    public T get(int row, int column) {
        return inner.get(row).get(column);
    }

    public int getRowCount() {
        return inner.size();
    }

    public int getColumnCount() {
        return inner.get(0).size();
    }

    public List<T> getRow(int row) {
        return inner.get(row);
    }

    public List<T> getColumn(int column) {
        List<T> result = inner.stream()
                .map(row -> row.get(column))
                .collect(Collectors.toList());
        return result;
    }

    public List<List<T>> getScans(int rowIndex, int columnIndex) {
        List<T> row = getRow(rowIndex);
        List<T> toRight = row.subList(columnIndex + 1, row.size());
        List<T> toLeft = new ArrayList<>(row.subList(0, columnIndex));
        Collections.reverse(toLeft);

        List<T> column = getColumn(columnIndex);
        List<T> toBottom = column.subList(rowIndex + 1, column.size());
        List<T> toTop = new ArrayList<>(column.subList(0, rowIndex));
        Collections.reverse(toTop);

        return Stream.of(toLeft, toRight, toTop, toBottom).collect(Collectors.toList());
    }

    public List<T> getAll() {
        return inner.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
