package com.cpt.adventofcode.solution.year2023.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 6, part = 2,
        description = "Wait For It",
        link = "https://adventofcode.com/2023/day/6#part2",
        tags = ""
)
public class Day6Part2Solution2023 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        List<String> input = Strings.toList(inputStream);

        String timeString = input.get(0)
                .replace("Time:", "")
                .replaceAll("\\s+", "");
        long time = Long.parseLong(timeString);

        String distanceString = input.get(1)
                .replace("Distance:", "")
                .replaceAll("\\s+", "");
        long distance = Long.parseLong(distanceString);

        return countBetterRaceDistances(time, distance);
    }

    private long countBetterRaceDistances(long time, long distance) {
        double discriminant = Math.sqrt(Math.pow(time, 2) - 4 * distance);
        long positiveRoot = (long) Math.ceil((time + discriminant) / 2);
        long negativeRoot = (long) Math.floor((time - discriminant) / 2);
        return positiveRoot - negativeRoot - 1;
    }

}