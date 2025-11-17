package com.cpt.adventofcode.output;

import com.cpt.adventofcode.result.Result;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class VerboseOutputProvider implements OutputProvider {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");

    @Override
    public String provide(List<Result<?>> results) {
        StringBuilder outputBuilder = new StringBuilder();

        results
                .stream()
                .collect(Collectors.groupingBy(result -> result.getSolutionInfo().getYear()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach((entry) -> {
                    outputBuilder.append("=".repeat(88)).append("\n");
                    entry.getValue().forEach(result -> outputBuilder.append(result.getVerbosePrintString()).append("\n"));
                });

        outputBuilder.append("=".repeat(88)).append("\n");

        Duration totalDuration = getTotalDuration(results);

        outputBuilder.append(String.format("%nSolved %d solutions with a total duration: %s seconds.%n", results.size(), FORMATTER.format(totalDuration.addTo(LocalDateTime.MIN))));

        return outputBuilder.toString();
    }

    private static Duration getTotalDuration(List<Result<?>> results) {
        return results.stream()
                .map(Result::getDuration)
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);
    }
}
