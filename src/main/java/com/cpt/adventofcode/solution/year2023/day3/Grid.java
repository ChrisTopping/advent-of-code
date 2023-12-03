package com.cpt.adventofcode.solution.year2023.day3;

import com.cpt.adventofcode.helpers.Strings;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Getter
public class Grid {

    private final Set<Number> numbers;
    private final Set<Symbol> symbols;

    public Grid(Stream<String> inputStream) {
        List<String> inputList = Strings.toList(inputStream);

        List<Line> lines = IntStream.range(0, inputList.size())
                .mapToObj(i -> new Line(inputList.get(i), i))
                .collect(Collectors.toList());

        numbers = lines.stream()
                .map(Line::getNumbers)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        symbols = lines.stream()
                .map(Line::getSymbols)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
