package com.cpt.adventofcode.solution.year2015.day14;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 14, part = 2,
        description = "Reindeer Olympics",
        link = "https://adventofcode.com/2015/day/14#part2"
)
public class Day14Part2Solution2015 implements Solution<Integer> {

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
        List<Reindeer> reindeer = inputStream.map(s -> {
            Strings.ItemMatcher itemMatcher = new Strings.ItemMatcher(PATTERN, PATTERN_MAP);
            Map<String, Object> details = Strings.parse(s, itemMatcher);

            int flightSpeed = Integer.parseInt(details.get("flightspeed").toString());
            int flightDuration = Integer.parseInt(details.get("flightduration").toString());
            int restDuration = Integer.parseInt(details.get("restduration").toString());

            return new Reindeer(flightSpeed, flightDuration, restDuration);
        }).toList();

        for (int i = 0; i < DURATION; i++) {
            reindeer.forEach(Reindeer::move);

            int maxDistance = reindeer.stream()
                    .mapToInt(Reindeer::getDistance)
                    .max()
                    .orElse(0);

            reindeer.stream()
                    .filter(r -> r.getDistance() == maxDistance)
                    .forEach(Reindeer::leading);
        }

        return reindeer.stream()
                .mapToInt(Reindeer::getPoints)
                .max()
                .orElseThrow();
    }

    @RequiredArgsConstructor
    static class Reindeer {
        private final int flightSpeed;
        private final int flightDuration;
        private final int restDuration;

        @Getter
        private int distance;
        @Getter
        private int points;
        private int clock;

        public void move() {
            int remainder = (clock % (flightDuration + restDuration));
            if (remainder < flightDuration) {
                this.distance += flightSpeed;
            }
            this.clock++;
        }

        public void leading() {
            this.points++;
        }
    }

}