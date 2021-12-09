package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 8, part = 2, description = "Seven Segment Search", tags = "alternative", link = "https://adventofcode.com/2021/day/8")
public class Day8Part2SolutionAlternative implements Solution<Long> {

    private final HashMap<Set<Segment>, Integer> segmentIntegerMap = new HashMap<>();

    public Day8Part2SolutionAlternative() {
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_LEFT, Segment.TOP_RIGHT, Segment.BOTTOM_LEFT, Segment.BOTTOM_RIGHT, Segment.BOTTOM), 0);
        segmentIntegerMap.put(Set.of(Segment.TOP_RIGHT, Segment.BOTTOM_RIGHT), 1);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_RIGHT, Segment.MIDDLE, Segment.BOTTOM_LEFT, Segment.BOTTOM), 2);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_RIGHT, Segment.MIDDLE, Segment.BOTTOM_RIGHT, Segment.BOTTOM), 3);
        segmentIntegerMap.put(Set.of(Segment.TOP_LEFT, Segment.TOP_RIGHT, Segment.MIDDLE, Segment.BOTTOM_RIGHT), 4);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_LEFT, Segment.MIDDLE, Segment.BOTTOM_RIGHT, Segment.BOTTOM), 5);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_LEFT, Segment.MIDDLE, Segment.BOTTOM_LEFT, Segment.BOTTOM_RIGHT, Segment.BOTTOM), 6);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_RIGHT, Segment.BOTTOM_RIGHT), 7);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_LEFT, Segment.TOP_RIGHT, Segment.MIDDLE, Segment.BOTTOM_LEFT, Segment.BOTTOM_RIGHT, Segment.BOTTOM), 8);
        segmentIntegerMap.put(Set.of(Segment.TOP, Segment.TOP_LEFT, Segment.TOP_RIGHT, Segment.MIDDLE, Segment.BOTTOM_RIGHT, Segment.BOTTOM), 9);
    }

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream.mapToLong(this::solve).sum();
    }

    public Long solve(String line) {
        String[] inputOutput = line.split(" \\| ");
        return calculateOutput(populateCharacterMap(inputOutput[0]), inputOutput[1]);
    }

    private long calculateOutput(Map<String, Segment> characterMap, String output) {
        return Long.parseLong(Arrays.stream(output.split(" "))
                .map(s -> Set.of(s.split("")))
                .map(s -> getSegmentsForCharacter(characterMap, s))
                .map(segmentIntegerMap::get)
                .map(String::valueOf)
                .collect(Collectors.joining("")));
    }

    private Map<String, Segment> populateCharacterMap(String input) {
        Map<Integer, String> digitMap = new HashMap<>();
        Map<Segment, String> segmentMap = new HashMap<>();

        String[] inputDigits = input.split(" ");
        populateInputsByUniqueLengths(digitMap, inputDigits);

        List<String> characters = Arrays.stream(input.split(""))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());

        populateSegmentsByUniqueFrequency(characters, segmentMap);

        populateSegmentsByFilteredFrequency(
                segmentMap,
                getCharactersByFrequency(characters, 8),
                List.of(digitMap.get(1).split("")),
                Segment.TOP_RIGHT,
                Segment.TOP
        );

        populateSegmentsByFilteredFrequency(
                segmentMap,
                getCharactersByFrequency(characters, 7),
                List.of(digitMap.get(4).split("")),
                Segment.MIDDLE,
                Segment.BOTTOM
        );

        return invert(segmentMap);
    }

    private void populateSegmentsByUniqueFrequency(List<String> characters, Map<Segment, String> segmentMap) {
        segmentMap.put(Segment.TOP_LEFT, getCharactersByFrequency(characters, 6).get(0));
        segmentMap.put(Segment.BOTTOM_LEFT, getCharactersByFrequency(characters, 4).get(0));
        segmentMap.put(Segment.BOTTOM_RIGHT, getCharactersByFrequency(characters, 9).get(0));
    }

    private void populateInputsByUniqueLengths(Map<Integer, String> inputMap, String[] inputDigits) {
        Arrays.stream(inputDigits)
                .map(s -> Arrays.stream(s.split("")).sorted().collect(Collectors.joining()))
                .forEach(s -> {
                    switch (s.length()) {
                        case 2 -> inputMap.put(1, s);
                        case 3 -> inputMap.put(7, s);
                        case 4 -> inputMap.put(4, s);
                        case 7 -> inputMap.put(8, s);
                    }
                });
    }

    private Set<Segment> getSegmentsForCharacter(Map<String, Segment> characterMap, Set<String> s) {
        return s.stream()
                .map(characterMap::get)
                .collect(Collectors.toSet());
    }

    private <T, V> Map<V, T> invert(Map<T, V> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    private void populateSegmentsByFilteredFrequency(Map<Segment, String> segmentMap, List<String> characters, List<String> segments, Segment containedCase, Segment notContainedCase) {
        Map<Boolean, List<String>> middleAndBottomMap = characters.stream().collect(Collectors.groupingBy(segments::contains));
        segmentMap.put(containedCase, middleAndBottomMap.get(Boolean.TRUE).get(0));
        segmentMap.put(notContainedCase, middleAndBottomMap.get(Boolean.FALSE).get(0));
    }

    public List<String> getCharactersByFrequency(List<String> characters, long occurrence) {
        return characters.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == occurrence)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public enum Segment {
        TOP,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        MIDDLE,
        BOTTOM,
        TOP_LEFT
    }

}
