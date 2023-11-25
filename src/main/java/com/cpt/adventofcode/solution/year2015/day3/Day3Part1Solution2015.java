package com.cpt.adventofcode.solution.year2015.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 3, part = 1,
        description = "Perfectly Spherical Houses in a Vacuum",
        link = "https://adventofcode.com/2015/day/3",
        tags = ""
)
public class Day3Part1Solution2015 implements Solution<Integer> {


    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> directions = Strings.splitAndCast(Strings.join(inputStream), "", Strings.Type.STRING);

        Santa santa = new Santa();

        for (String direction : directions) {
            santa.move(direction);
        }

        return santa.getVisited().size();
    }

}