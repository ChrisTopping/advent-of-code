package com.cpt.adventofcode.solution.year2024.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import dev.christopping.tensor.Matrix;

import java.util.stream.Stream;


@AdventOfCodeSolution(year = 2024, day = 4, part = 1,
        description = "Ceres Search",
        link = "https://adventofcode.com/2024/day/4"
)
public class Day4Part1Solution2024 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Matrix<String> matrix = Matrix.of(inputStream.map(s -> s.split(""))
                .toArray(String[][]::new));

        Matrix<String> skewed = MatrixUtils.skew(matrix);
        Matrix<String> rotated = MatrixUtils.rotate(matrix);
        Matrix<String> rotatedSkewed = MatrixUtils.rotate(skewed);
        return Stream.of(
                        MatrixUtils.count(matrix, "XMAS"),
                        MatrixUtils.count(matrix, "SAMX"),
                        MatrixUtils.count(rotated, "XMAS"),
                        MatrixUtils.count(rotated, "SAMX"),
                        MatrixUtils.count(skewed, "X.M.A.S"),
                        MatrixUtils.count(skewed, "S.A.M.X"),
                        MatrixUtils.count(rotatedSkewed, "X.M.A.S"),
                        MatrixUtils.count(rotatedSkewed, "S.A.M.X")
                ).mapToInt(Integer::intValue)
                .sum();
    }

}