package com.cpt.adventofcode.solution.year2021.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 5, part = 2,
        description = "Hydrothermal Venture",
        link = "https://adventofcode.com/2021/day/5"
)
@RequiredArgsConstructor
public class Day5Part2Solution2021 implements Solution<Integer> {


    @Override
    public Integer solve(Stream<String> inputStream) {
        List<Line> lines = inputStream
                .map(Line::new)
                .collect(Collectors.toList());

        int maxValue = lines.stream().map(Line::getPointsOnLine)
                .flatMap(Collection::stream)
                .mapToInt(point -> Math.max(point.getX(), point.getY()))
                .max()
                .orElse(0);

        Grid grid = new Grid(maxValue + 1, maxValue + 1);
        lines.forEach(grid::apply);

        return grid.sumAtOrAboveThreshold(2);
    }
}
