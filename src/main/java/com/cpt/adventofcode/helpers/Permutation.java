package com.cpt.adventofcode.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

    public static <T> List<List<T>> permute(List<T> items) {
        List<List<T>> permutations = new ArrayList<>();
        recursivePermute(items, 0, permutations);
        return permutations;
    }

    private static <T> void recursivePermute(List<T> permutation, int current, List<List<T>> permutations) {
        if (current == permutation.size()) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = current; i < permutation.size(); i++) {
            Collections.swap(permutation, i, current);
            recursivePermute(permutation, current + 1, permutations);
            Collections.swap(permutation, i, current);
        }
    }
}
