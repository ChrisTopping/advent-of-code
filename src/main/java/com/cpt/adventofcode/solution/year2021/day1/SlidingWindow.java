package com.cpt.adventofcode.solution.year2021.day1;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SlidingWindow {

    public static <T> Stream<List<T>> of(List<T> list, int size) {
        return IntStream.range(0, list.size() - size + 1)
                .mapToObj(start -> list.subList(start, start + size));
    }

}
