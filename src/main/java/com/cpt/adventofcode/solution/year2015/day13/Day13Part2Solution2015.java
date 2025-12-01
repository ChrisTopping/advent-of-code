package com.cpt.adventofcode.solution.year2015.day13;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Permutation;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 13, part = 2,
        description = "Knights of the Dinner Table",
        link = "https://adventofcode.com/2015/day/13#part2"
)
public class Day13Part2Solution2015 implements Solution<Integer> {

    private static final Map<String, Strings.Type> PAIRING_PATTERN_MAP = Map.of(
            "first", Strings.Type.STRING,
            "sign", Strings.Type.STRING,
            "units", Strings.Type.INTEGER,
            "second", Strings.Type.STRING
    );
    private static final String PAIRING_PATTERN = "(?<first>\\w+) would (?<sign>gain|lose) (?<units>\\d+) happiness units by sitting next to (?<second>\\w+)\\.";

    @Override
    public Integer solve(Stream<String> inputStream) {
        Strings.ItemMatcher itemMatcher = new Strings.ItemMatcher(PAIRING_PATTERN, PAIRING_PATTERN_MAP);
        Arrangement arrangement = new Arrangement();

        inputStream
                .map(s -> Strings.parse(s, itemMatcher))
                .forEach(map -> {
                            Guest first = arrangement.putIfAbsent(map.get("first").toString());
                            Guest second = arrangement.putIfAbsent(map.get("second").toString());
                            int weight = Integer.parseInt(map.get("units").toString());
                            String sign = map.get("sign").toString();
                            first.addWeight(second, sign.equals("gain") ? weight : -weight);
                        }
                );

        arrangement.putIfAbsent("self");

        ArrayList<Guest> guests = new ArrayList<>(arrangement.getGuests());

        return Permutation.permute(guests)
                .stream()
                .mapToInt(permutation -> {
                    int distance = 0;
                    for (int i = 0; i < permutation.size() - 1; i++) {
                        distance += permutation.get(i).getWeight(permutation.get(i + 1));
                    }
                    distance += permutation.getLast().getWeight(permutation.getFirst());
                    return distance;
                }).max()
                .orElse(0);
    }

}