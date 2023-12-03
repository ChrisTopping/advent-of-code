package com.cpt.adventofcode.solution.year2023.day3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
final class Symbol {
    private final int x;
    private final int y;
    private final String character;
    private Set<Number> numbers = new HashSet<>();

    public void addNumber(Number number) {
        numbers.add(number);
    }

    public int getGearRatio() {
        return isGear() ? numbers.stream().mapToInt(Number::getNumber).reduce((i, j) -> i * j).orElse(0) : 0;
    }

    private boolean isGear() {
        return character.equals("*") && numbers.size() == 2;
    }

}
