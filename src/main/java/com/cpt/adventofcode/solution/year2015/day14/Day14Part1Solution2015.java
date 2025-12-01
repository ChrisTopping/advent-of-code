package com.cpt.adventofcode.solution.year2015.day14;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.Map;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 14, part = 1,
        description = "Reindeer Olympics",
        link = "https://adventofcode.com/2015/day/14"
)
public class Day14Part1Solution2015 implements Solution<Integer> {

    private static final Map<String, Strings.Type> PATTERN_MAP = Map.of(
            "name", Strings.Type.STRING,
            "flightspeed", Strings.Type.INTEGER,
            "flightduration", Strings.Type.INTEGER,
            "restduration", Strings.Type.INTEGER
    );
    private static final String PATTERN = "(?<name>\\w+) can fly (?<flightspeed>\\d+) km/s for (?<flightduration>\\d+) seconds, but then must rest for (?<restduration>\\d+) seconds.";

    private static final int DURATION = 2503;

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream.mapToInt(s -> {
                    Strings.ItemMatcher itemMatcher = new Strings.ItemMatcher(PATTERN, PATTERN_MAP);
                    Map<String, Object> details = Strings.parse(s, itemMatcher);

                    int flightSpeed = Integer.parseInt(details.get("flightspeed").toString());
                    int flightDuration = Integer.parseInt(details.get("flightduration").toString());
                    int restDuration = Integer.parseInt(details.get("restduration").toString());

                    int numberOfWholeFlights = DURATION / (flightDuration + restDuration);
                    int remainder = Math.floorMod(DURATION, flightDuration + restDuration);
                    int partialFlightDuration = Math.min(flightDuration, remainder);

                    return flightSpeed * (numberOfWholeFlights * flightDuration + partialFlightDuration);
                }).max()
                .orElseThrow();
    }

}