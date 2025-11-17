package com.cpt.adventofcode.output;

import com.cpt.adventofcode.result.Result;
import com.diogonunes.jcolor.AnsiFormat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class DefaultOutputProvider implements OutputProvider {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");

    @Override
    public String provide(List<Result<?>> results) {
        StringBuilder outputBuilder = new StringBuilder().append(Result.getLaconicHeaders()).append("\n");

        results
                .stream()
                .collect(Collectors.groupingBy(result -> result.getSolutionInfo().getYear()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach((entry) -> {
                    outputBuilder.append("=".repeat(88)).append("\n");
                    entry.getValue().forEach(result -> outputBuilder.append(printResult(getMaxDuration(results), result)).append("\n"));
                });

        outputBuilder.append("=".repeat(88)).append("\n");

        Duration totalDuration = getTotalDuration(results);

        outputBuilder.append(String.format("%nSolved %d solutions with a total duration: %s seconds.%n", results.size(), FORMATTER.format(totalDuration.addTo(LocalDateTime.MIN))));

        return outputBuilder.toString();
    }

    private static String printResult(long maxDuration, Result<?> result) {
        double relativeDuration = 1.0 * result.getDuration().toMillis() / maxDuration;
        double relativeDurationLog = relativeDuration == 1 ? 1 : 1.0 / Math.log10(1/relativeDuration);
        int red = Math.max(Math.min((int) (255 * relativeDurationLog), 255), 0);
        int green = Math.max(Math.min((int) (255 * (1 - relativeDurationLog)), 255), 0);
        return result.getLaconicPrintString(new AnsiFormat(TEXT_COLOR(red, green, 0)));
    }

    private static long getMaxDuration(List<Result<?>> results) {
        return results.stream()
                .map(Result::getDuration)
                .mapToLong(Duration::toMillis)
                .max().orElse(0);
    }

    private static Duration getTotalDuration(List<Result<?>> results) {
        return results.stream()
                .map(Result::getDuration)
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);
    }
}
