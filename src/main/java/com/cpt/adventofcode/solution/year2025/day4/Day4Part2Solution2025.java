package com.cpt.adventofcode.solution.year2025.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.cpt.adventofcode.solution.year2024.day4.MatrixUtils;
import dev.christopping.tensor.Matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 4, part = 2,
        description = "Printing Department",
        link = "https://adventofcode.com/2025/day/4#part2"
)
public class Day4Part2Solution2025 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<List<String>> input = inputStream.map(s -> Arrays.stream(s.split("")).toList())
                .toList();
        Matrix<String> map = Matrix.of(input);

        int removed = 0;

        while (true) {
            Matrix<String> finalMap = map;
            Matrix<String> updatedMap = map.computeWithIndices(entry -> {
                if (entry.getValue().equals("@")) {
                    List<String> neighbours = MatrixUtils.getNeighbours(finalMap, entry.getKey());
                    long paperNeighbourCount = neighbours.stream()
                            .filter(s -> s.equals("@"))
                            .count();

                    if (paperNeighbourCount < 4) {
                        return "x";
                    }
                }

                return entry.getValue();
            });

            int removedThisRound = Math.toIntExact(updatedMap.elements().stream().filter(s -> s.equals("x")).count());
            map = updatedMap.compute(s -> s.equals("x") ? "." : s);
            if (removedThisRound == 0) {
                break;
            } else {
                removed += removedThisRound;
            }
        }
        return removed;

    }

}