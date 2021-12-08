package com.cpt.adventofcode.result;

import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@RequiredArgsConstructor
public class Result<T> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");
    private static final String PRINT_FORMAT = "Year %d Day %d Part %d:\n    Name: %s\n    Link: %s\n    Tags: %s\n    Solution: %s\n    Duration: %s seconds";

    private final T value;
    private final Duration duration;
    private final AdventOfCodeSolutionResolver.SolutionInfo solutionInfo;

    public String getPrintString() {
        return String.format(PRINT_FORMAT,
                solutionInfo.getYear(),
                solutionInfo.getDay(),
                solutionInfo.getPart(),
                solutionInfo.getDescription(),
                solutionInfo.getLink(),
                "[" + String.join(", ", solutionInfo.getTags()) + "]",
                value,
                FORMATTER.format(duration.addTo(LocalDateTime.MIN))
        );
    }
}
