package com.cpt.adventofcode.solution.year2023.day3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
class Number {
    private final int number;
    private final int xStart;
    private final int xEnd;
    private final int y;
    @Setter
    private List<Symbol> adjacentSymbols = new ArrayList<>();

    public void visit(Symbol symbol) {
        if (isAdjacent(symbol)) {
            adjacentSymbols.add(symbol);
            symbol.addNumber(this);
        }
    }

    public boolean isSerialNumber() {
        return adjacentSymbols.size() > 0;
    }

    private boolean isAdjacent(Symbol symbol) {
        return isWithinXRange(symbol) && isWithinYRange(symbol);
    }

    private boolean isWithinYRange(Symbol symbol) {
        return (isBetween(symbol.getY(), y - 1, y + 1));
    }

    private boolean isWithinXRange(Symbol symbol) {
        return (isBetween(symbol.getX(), xStart - 1, xEnd + 1));
    }

    private boolean isBetween(int value, int lower, int upper) {
        return value >= lower && value <= upper;
    }
}
