package com.cpt.adventofcode.solution.year2021.day6;

import com.cpt.adventofcode.solution.Solution;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day6Solution implements Solution<Long> {

    private static final String DAYS_DELIMITER = ",";
    public final int days;

    @Override
    public Long solve(Stream<String> inputStream) {
        String input = inputStream.collect(Collectors.joining());

        Map<Long, Long> countMap = Arrays.stream(input.split(DAYS_DELIMITER))
                .map(Long::parseLong)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Collector<Map.Entry<Long, Long>, ?, Map<Long, Long>> decrementingCollector = Collectors.toMap(
                entry -> decrementDays(entry.getKey()),
                Map.Entry::getValue,
                (count1, count2) -> orZero(count1) + orZero(count2)
        );

        for (int i = 0; i < days; i++) {
            countMap.put(9L, countMap.get(0L));
            countMap = countMap.entrySet().stream()
                    .peek(this::defaultNullToZero)
                    .collect(decrementingCollector);
        }

        return countMap.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private void defaultNullToZero(Map.Entry<Long, Long> entry) {
        if (entry.getValue() == null) {
            entry.setValue(0L);
        }
    }

    private long decrementDays(long daysLeft) {
        return daysLeft == 0 ? 6 : daysLeft - 1;
    }

    private long orZero(Long daysLeft) {
        return Optional.of(daysLeft)
                .orElse(0L);
    }
}
