package com.cpt.adventofcode.solution.year2015.day9;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Permutation;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 9, part = 2,
        description = "All in a Single Night",
        link = "https://adventofcode.com/2015/day/9#part2"
)
public class Day9Part2Solution2015 implements Solution<Integer> {

    private static final Map<String, Strings.Type> ROUTE_PATTERN_MAP = Map.of(
            "from", Strings.Type.STRING,
            "to", Strings.Type.STRING,
            "distance", Strings.Type.STRING
    );
    private static final String ROUTE_PATTERN = "(?<from>\\w+) to (?<to>\\w+) = (?<distance>\\w+)";

    @Override
    public Integer solve(Stream<String> inputStream) {
        Strings.ItemMatcher itemMatcher = new Strings.ItemMatcher(ROUTE_PATTERN, ROUTE_PATTERN_MAP);

        World world =World.createWorld();

        inputStream
                .map(s -> Strings.parse(s, itemMatcher))
                .forEach(map -> {
                            City from = world.putIfAbsent(map.get("from").toString());
                            City to = world.putIfAbsent(map.get("to").toString());
                            int distance = Integer.parseInt(map.get("distance").toString());
                            from.addRoute(to, distance);
                            to.addRoute(from, distance);
                        }
                );

        ArrayList<City> cities = new ArrayList<>(world.getCites());

        return Permutation.permute(cities)
                .stream()
                .mapToInt(permutation -> {
                    int distance = 0;
                    for (int i = 0; i < permutation.size() - 1; i++) {
                        distance += permutation.get(i).getDistanceTo(permutation.get(i + 1));
                    }
                    return distance;
                }).max()
                .orElse(0);
    }

}