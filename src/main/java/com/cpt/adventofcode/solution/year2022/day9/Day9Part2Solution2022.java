package com.cpt.adventofcode.solution.year2022.day9;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Collection;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 9, part = 2,
        description = "Rope Bridge",
        link = "https://adventofcode.com/2022/day/9#part2",
        tags = ""
)
public class Day9Part2Solution2022 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Rope rope = Rope.ofSize(10);
        inputStream
                .map(Command::new)
                .map(Command::breakOutDirections)
                .flatMap(Collection::stream)
                .forEach(rope::moveHead);

        return rope.countUniqueTailPositions();
    }

}