package com.cpt.adventofcode.helpers;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SlidingWindow {

    public static <T> Stream<List<T>> of(List<T> list, int size) {
        return IntStream.range(0, list.size() - size + 1)
                .mapToObj(start -> list.subList(start, start + size));
    }

}
