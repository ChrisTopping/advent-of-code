package com.cpt.adventofcode.solution.year2023.day6;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 6, part = 1,
        description = "Wait For It",
        link = "https://adventofcode.com/2023/day/6",
        tags = ""
)
public class Day6Part1Solution2023 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> input = Strings.toList(inputStream);

        String timesString = input.get(0).replace("Time:", "").trim();
        List<Integer> times = Strings.splitAndCast(timesString, "\\s+", Strings.Type.INTEGER);

        String distancesString = input.get(1).replace("Distance:", "").trim();
        List<Integer> distances = Strings.splitAndCast(distancesString, "\\s+", Strings.Type.INTEGER);

        return IntStream.range(0, times.size())
                .map(race -> countBetterRaceDistances(times.get(race), distances.get(race)))
                .reduce((left, right) -> left * right)
                .orElseThrow();
    }

    private int countBetterRaceDistances(long time, long distance) {
        double discriminant = Math.sqrt(Math.pow(time, 2) - 4 * distance);
        int positiveRoot = (int) Math.ceil((time + discriminant) / 2);
        int negativeRoot = (int) Math.floor((time - discriminant) / 2);
        return positiveRoot - negativeRoot - 1;
    }

}
