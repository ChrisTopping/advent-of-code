package com.cpt.adventofcode.solution.year2015.day12;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 12, part = 2,
        description = "JSAbacusFramework.io",
        link = "https://adventofcode.com/2015/day/12#part2"
)
public class Day12Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        String input = inputStream.collect(Collectors.joining(""));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(input);
            return sumNonRedAdjacent(root);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private int sumNonRedAdjacent(JsonNode node) {
        if (node.isNumber()) {
            return node.asInt();
        } else if (node.isTextual()) {
            return 0;
        } else if (node.isArray()) {
            int sum = 0;
            for (JsonNode element : node) {
                sum += sumNonRedAdjacent(element);
            }
            return sum;
        } else if (node.isObject()) {
            int sum = 0;
            for (JsonNode element : node) {
                if (element.isTextual() && element.asText().equals("red")) {
                    return 0;
                } else {
                    sum += sumNonRedAdjacent(element);
                }
            }
            return sum;
        } else {
            return 0;
        }
    }

}