package com.cpt.adventofcode.solution.year2022.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 8, part = 1,
        description = "Treetop Tree House",
        link = "https://adventofcode.com/2022/day/8",
        tags = ""
)
public class Day8Part1Solution2022 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Matrix<Tree> trees = new Matrix<>();
        inputStream
                .map(this::getRowHeights)
                .forEach(trees::addRow);

        int rowCount = trees.getRowCount();
        int columnCount = trees.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                List<List<Tree>> scans = trees.getScans(row, column);
                Tree tree = trees.get(row, column);
                scans.forEach(scan -> {
                    if (scan.size() == 0) {
                        tree.setVisible();
                    }
                    boolean isVisible = scan.stream()
                            .map(tree::isTallerThan)
                            .reduce((first, second) -> first && second)
                            .orElse(false);
                    if (isVisible) {
                        tree.setVisible();
                    }
                });
            }
        }

        return Math.toIntExact(trees.getAll().stream().filter(Tree::isVisible).count());
    }

    private void solve2(Stream<String> inputStream) {
        Matrix<Tree> trees = new Matrix<>();
        inputStream
                .map(this::getRowHeights)
                .forEach(trees::addRow);

        int rowCount = trees.getRowCount();
        int columnCount = trees.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                List<List<Tree>> scans = trees.getScans(row, column);
                Tree tree = trees.get(row, column);
                scans.forEach(scan -> {
                    for (Tree other : scan) {
                        if (tree.isTallerThan(other)) {
                            tree.setVisible();
                        }
                    }
                });
            }
        }
    }

    private List<Tree> getRowHeights(String s) {
        return Arrays
                .stream(s.split(""))
                .map(Integer::parseInt)
                .map(Tree::new)
                .collect(Collectors.toList());
    }

}