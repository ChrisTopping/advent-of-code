package com.cpt.adventofcode.solution.year2023.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 8, part = 1,
        description = "Haunted Wasteland",
        link = "https://adventofcode.com/2023/day/8",
        tags = ""
)
public class Day8Part1Solution2023 implements Solution<Integer> {

    private static final String START = "AAA";
    private static final String FINISH = "ZZZ";

    private static final Map<String, Strings.Type> NODE_PATTERN_MAP = Map.of(
            "name", Strings.Type.STRING,
            "left", Strings.Type.STRING,
            "right", Strings.Type.STRING
    );
    private static final String NODE_PATTERN = "(?<name>\\w+)\\s+=\\s\\((?<left>\\w+),\\s+(?<right>\\w+)\\)";

    private final Map<String, String> nodeMap = new HashMap<>();

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> input = inputStream.collect(Collectors.toList());
        List<String> directions = getDirections(input);
        buildNodeMap(input);
        return traverse(directions);
    }

    @NotNull
    private List<String> getDirections(List<String> input) {
        return Arrays.stream(input.get(0).split(""))
                .collect(Collectors.toList());
    }

    private void buildNodeMap(List<String> input) {
        input.subList(2, input.size())
                .forEach(this::buildNode);
    }

    private void buildNode(String s) {
        Strings.ItemMatcher matcher = new Strings.ItemMatcher(NODE_PATTERN, NODE_PATTERN_MAP);
        Map<String, Object> result = Strings.parse(s, matcher);
        nodeMap.put(result.get("name") + "L", result.get("left") + "");
        nodeMap.put(result.get("name") + "R", result.get("right") + "");
    }

    private int traverse(List<String> directions) {
        int count = 0;
        String current = START;

        while (true) {
            if (current.equals(FINISH)) {
                return count;
            } else {
                current = nodeMap.get(current + directions.get(count % directions.size()));
                count += 1;
            }
        }
    }

}