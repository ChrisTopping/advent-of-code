package com.cpt.adventofcode.solution.year2023.day5;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 5, part = 2,
        description = "If You Give A Seed A Fertilizer",
        link = "https://adventofcode.com/2023/day/5#part2",
        tags = "unsolved"
)
public class Day5Part2Solution2023 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        List<String> groups = Arrays.asList(inputStream.collect(Collectors.joining("\n")).split("\\n\\n"));

        List<Range> seeds = Lists.partition(Strings.splitAndCast(groups.get(0).replaceAll("^.*:\\s+", ""), "\\s+", Strings.Type.LONG), 2)
                .stream()
                .map(seedRange -> {
                    long start = (long) seedRange.get(0);
                    long accumulator = (long) seedRange.get(1);
                    return new Range(start, start + accumulator - 1);
                }).collect(Collectors.toList());

        List<MappingGroup> mappingGroups = groups.subList(1, groups.size()).stream()
                .map(groupString -> {
                    String[] rows = groupString.replaceAll("^.*:\\s+", "").split("\\n");

                    List<Mapping> mappings = Arrays.stream(rows)
                            .map(row -> {
                                List<Long> longs = Strings.splitAndCast(row, "\\s+", Strings.Type.LONG);
                                Range source = new Range(longs.get(1), longs.get(1) + longs.get(2) - 1);
                                Range destination = new Range(longs.get(0), longs.get(0) + longs.get(2) - 1);
                                return new Mapping(source, destination);
                            })
                            .collect(Collectors.toList());
                    return new MappingGroup(mappings);
                }).collect(Collectors.toList());

        return seeds.stream()
                .map(range -> mappingGroups.stream()
                        .reduce(List.of(range), (ranges, mappingGroup) -> mappingGroup.map(ranges), (objects, objects2) -> objects2))
                .flatMap(Collection::stream)
                .mapToLong(range -> range.start)
                .min()
                .orElseThrow();
    }

    private static record Range(long start, long end) {
    }

    private static record Mapping(Range source, Range destination) {

        public boolean sourceIntersects(Range other) {
            return !(other.start > source.end || source.start > other.end);
        }

        public List<Range> map(Range from) {
            List<Range> ranges = new ArrayList<>();

            if (from.start < source.start) {
                ranges.add(new Range(Math.min(from.start, source.start), Math.max(from.start, source.start) - 1L));
            }

            long diff = destination.start - source.start;
            ranges.add(new Range(Math.max(from.start, source.start) + diff, Math.min(from.end, source.end) + diff));

            if (from.end > source.end) {
                ranges.add(new Range(Math.min(from.end, source.end) + 1, Math.max(from.end, source.end)));
            }

            return ranges;
        }
    }

    private static record MappingGroup(List<Mapping> mappings) {

        public List<Range> map(List<Range> from) {
            return from.stream()
                    .map(range -> {
                        return mappings.stream()
                                .filter(mapping -> mapping.sourceIntersects(range))
                                .map(mapping -> mapping.map(range))
                                .findAny()
                                .orElse(List.of(range));
                    }).flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
    }

}