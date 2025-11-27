package com.cpt.adventofcode.solution.year2024.day4;

import com.cpt.adventofcode.helpers.Strings;
import dev.christopping.tensor.Index;
import dev.christopping.tensor.Matrix;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MatrixUtils {

    public static Matrix<String> skew(Matrix<String> matrix) {
        long size = matrix.size(0) - 1;

        Function<Map.Entry<Index, String>, Map.Entry<Index, String>> function = e -> {
            Index key = e.getKey();
            var x = key.get(0) + key.get(1);
            var y = size - x + 2 * key.get(1);
            return Map.entry(
                    Index.of(y, x),
                    e.getValue()
            );
        };
        Matrix<String> skewed = matrix.computeAndUpdateIndices(function)
                .toMatrix();
        skewed.set(".", size * 2 - 2,size * 2 - 2);
        return skewed.backfill(".");
    }

    public static Matrix<String> rotate(Matrix<String> matrix) {
        return matrix.computeAndUpdateIndices(e -> Map.entry(Index.of(e.getKey().get(1), e.getKey().get(0)), e.getValue())).toMatrix();
    }

    public static int count(Matrix<String> matrix, String needle) {
        return matrix.toNestedList().stream()
                .map(row -> String.join("", row))
                .mapToInt(row -> count(row, needle))
                .sum();
    }

    static int count(String row, String needle) {
        Strings.ItemMatcher matcher = new Strings.ItemMatcher("(?<needle>%s)".formatted(needle), Map.of("needle", Strings.Type.STRING));
        return Strings.parseAll(row, matcher)
                .getOrDefault("needle", List.of()).size();
    }

    public static Matrix<String> subMatrix(Matrix<String> matrix, Index size, Index start) {
        return Matrix.generate(index -> matrix.get(index.get(0) + start.get(0), index.get(1) + start.get(1)), size)
                .toMatrix();
    }

}
