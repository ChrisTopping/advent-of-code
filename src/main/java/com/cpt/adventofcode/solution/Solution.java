package com.cpt.adventofcode.solution;

import java.util.stream.Stream;

public interface Solution<T> {

    T solve(Stream<String> inputStream);

}
