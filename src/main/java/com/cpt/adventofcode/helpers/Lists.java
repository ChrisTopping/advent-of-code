package com.cpt.adventofcode.helpers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

    public static <T> List<T> reverse(List<T> list) {
        return list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}
