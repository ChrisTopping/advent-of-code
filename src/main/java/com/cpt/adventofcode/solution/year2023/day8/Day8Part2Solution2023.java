package com.cpt.adventofcode.solution.year2023.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Maths;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 8, part = 2,
        description = "Haunted Wasteland",
        link = "https://adventofcode.com/2023/day/8#part2",
        tags = ""
)
public class Day8Part2Solution2023 implements Solution<Long> {

    private static final Map<String, Strings.Type> NODE_PATTERN_MAP = Map.of(
            "name", Strings.Type.STRING,
            "left", Strings.Type.STRING,
            "right", Strings.Type.STRING
    );
    private static final String NODE_PATTERN = "(?<name>\\w+)\\s+=\\s\\((?<left>\\w+),\\s+(?<right>\\w+)\\)";

    private final Map<String, String> nodeMap = new HashMap<>();

    @Override
    public Long solve(Stream<String> inputStream) {
        List<String> input = inputStream.collect(Collectors.toList());
        List<String> directions = getDirections(input);
        List<String> startingNodes = getStartingNodes(input);
        buildNodeMap(input);

        List<Long> counts = startingNodes.stream()
                .map(s -> traverse(directions, s))
                .collect(Collectors.toList());

        return Maths.lcm(counts);
    }

    @NotNull
    private List<String> getDirections(List<String> input) {
        return Arrays.stream(input.get(0).split(""))
                .collect(Collectors.toList());
    }

    private List<String> getStartingNodes(List<String> input) {
        return input.subList(2, input.size())
                .stream()
                .map(s -> s.split(" = ")[0])
                .filter(s -> s.endsWith("A"))
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

    private long traverse(List<String> directions, String startingNode) {
        int count = 0;
        String current = startingNode;

        while (true) {
            if (current.endsWith("Z")) {
                return count;
            } else {
                int finalCount = count;
                current = nodeMap.get(current + directions.get(finalCount % directions.size()));
                count += 1;
            }
        }
    }

}