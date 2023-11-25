package com.cpt.adventofcode.solution.year2015.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 3, part = 2,
        description = "Perfectly Spherical Houses in a Vacuum",
        link = "https://adventofcode.com/2015/day/3#part2",
        tags = ""
)
public class Day3Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> directions = Strings.splitAndCast(Strings.join(inputStream), "", Strings.Type.STRING);

        Santa santa = new Santa();
        Santa roboSanta = new Santa();

        List<String> santaDirections = IntStream
                .range(0, directions.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(directions::get)
                .collect(Collectors.toList());

        List<String> roboSantaDirections = IntStream
                .range(0, directions.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(directions::get)
                .collect(Collectors.toList());

        santaDirections.forEach(santa::move);
        roboSantaDirections.forEach(roboSanta::move);

        Set<House> allHouses = new HashSet<>();
        allHouses.addAll(santa.getVisited());
        allHouses.addAll(roboSanta.getVisited());


        return allHouses.size();
    }

}