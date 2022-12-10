package com.cpt.adventofcode.solution.year2022.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 8, part = 2,
        description = "Treetop Tree House",
        link = "https://adventofcode.com/2022/day/8#part2",
        tags = ""
)
public class Day8Part2Solution implements Solution<Integer> {

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
                    int maxHeight = tree.getHeight();
                    AtomicInteger count = new AtomicInteger(1);
                    for (Tree other : scan) {
                        if (other.getHeight() >= maxHeight) {
                            break;
                        }
                        count.set(count.get() + 1);
                    }
                    tree.multiplyScenicScore(Math.toIntExact(Math.min(count.get(), scan.size())));
                });
            }
        }

        return trees.getAll().stream()
                .mapToInt(Tree::getScenicScore)
                .max()
                .orElseThrow();
    }

    private List<Tree> getRowHeights(String s) {
        return Arrays
                .stream(s.split(""))
                .map(Integer::parseInt)
                .map(Tree::new)
                .collect(Collectors.toList());
    }

}