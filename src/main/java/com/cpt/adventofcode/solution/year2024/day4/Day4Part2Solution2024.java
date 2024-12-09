package com.cpt.adventofcode.solution.year2024.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import dev.christopping.tensor.Index;
import dev.christopping.tensor.Matrix;

import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2024, day = 4, part = 2,
        description = "Ceres Search",
        link = "https://adventofcode.com/2024/day/4#part2",
        tags = "slow"
)
public class Day4Part2Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Matrix<String> matrix = Matrix.of(inputStream.map(s -> s.split(""))
                .toArray(String[][]::new));

        List<String> patterns = List.of(
                "M . S\\|. A .\\|M . S",
                "M . M\\|. A .\\|S . S",
                "S . M\\|. A .\\|S . M",
                "S . S\\|. A .\\|M . M"
        );
        Index sizeIndex = Index.of(2, 2);

        int matches = 0;

        for (int i = 0; i < matrix.dimensions().get(0) - 2; i++) {
            for (int j = 0; j < matrix.dimensions().get(1) - 2; j++) {
                Matrix<String> stringMatrix = MatrixUtils.subMatrix(matrix, sizeIndex, Index.of(i, j));

                matches += patterns.stream()
                        .anyMatch(s -> stringMatrix.toString("", "", " ", "|", ".", false).matches(s)) ? 1 : 0;
            }
        }

        return matches;
    }

}