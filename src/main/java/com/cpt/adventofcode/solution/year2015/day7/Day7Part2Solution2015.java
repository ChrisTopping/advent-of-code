package com.cpt.adventofcode.solution.year2015.day7;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 7, part = 2,
        description = "Some Assembly Required",
        link = "https://adventofcode.com/2015/day/7#part2"
)
public class Day7Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        var wireToFind = "a";
        var wireToReplace = "b";

        Map<String, Wire> wires = inputStream.toList().stream()
                .map(s -> {
                    String[] split = s.split("->");
                    return new Wire(split[1].trim(), split[0].trim());
                }).collect(Collectors.toMap(Wire::getName, Function.identity()));

        int wireValue = wires.getOrDefault(wireToFind, new Wire("", "0")).evaluate(wires);

        wires.values().forEach(wire -> wire.setValue(null));
        wires.getOrDefault(wireToReplace, new Wire("", "0")).setValue(wireValue);

        return wires.getOrDefault(wireToFind, new Wire("", "0")).evaluate(wires);
    }

}