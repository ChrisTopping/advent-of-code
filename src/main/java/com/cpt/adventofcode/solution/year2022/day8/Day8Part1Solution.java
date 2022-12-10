package com.cpt.adventofcode.solution.year2022.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 8, part = 1,
        description = "Treetop Tree House",
        link = "https://adventofcode.com/2022/day/8",
        tags = ""
)
public class Day8Part1Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Matrix<Tree> trees = new Matrix<>();
        inputStream
                .map(this::getRowHeights)
                .forEach(trees::addRow);

        int rowCount = trees.getRowCount();

        IntStream.range(0, rowCount)
                .forEach(row -> {
                    ArrayList<Tree> tempRow = new ArrayList<>(trees.getRow(row));
                    processLine(tempRow);
                    Collections.reverse(tempRow);
                    processLine(tempRow);
                });

        int columnCount = trees.getColumnCount();

        IntStream.range(0, columnCount)
                .forEach(column -> {
                    ArrayList<Tree> tempColumn = new ArrayList<>(trees.getColumn(column));
                    processLine(tempColumn);
                    Collections.reverse(tempColumn);
                    processLine(tempColumn);
                });

        return Math.toIntExact(trees.getAll().stream().filter(Tree::isVisible).count());
    }

    private void processLine(List<Tree> line) {
        AtomicReference<Tree> preceding = new AtomicReference<>(null);
        line.forEach(tree -> preceding.set(tree.applyPreceding(preceding.get())));
    }

    private List<Tree> getRowHeights(String s) {
        return Arrays
                .stream(s.split(""))
                .map(Integer::parseInt)
                .map(Tree::new)
                .collect(Collectors.toList());
    }

}