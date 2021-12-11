package com.cpt.adventofcode.result;

import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import com.diogonunes.jcolor.AnsiFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.diogonunes.jcolor.Ansi.colorize;

@Data
@AllArgsConstructor
public class Result<T> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");
    private static final String VERBOSE_PRINT_STRING = "Year %d Day %d Part %d:\n    Name: %s\n    Link: %s\n    Tags: %s\n    Solution: %s\n    Duration: %s seconds";
    private static final String LACONIC_PRINT_STRING = "%-4d %-3d %-4d %-45s %-15s %s";
    private static final String LACONIC_PRINT_HEADERS= "%-4s %-3s %-4s %-45s %-15s %s";

    private final T value;
    private final AdventOfCodeSolutionResolver.SolutionInfo solutionInfo;
    @Setter
    private Duration duration;

    public String getVerbosePrintString() {
        return String.format(VERBOSE_PRINT_STRING,
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

    public String getLaconicPrintString(AnsiFormat format) {
        return String.format(LACONIC_PRINT_STRING,
                solutionInfo.getYear(),
                solutionInfo.getDay(),
                solutionInfo.getPart(),
                solutionInfo.getDescription(),
                value,
                colorize(FORMATTER.format(duration.addTo(LocalDateTime.MIN)), format)
        );
    }

    public static String getLaconicHeaders() {
        return String.format(LACONIC_PRINT_HEADERS,
                "Year",
                "Day",
                "Part",
                "Name",
                "Result",
                "Duration (s)"
        );
    }
}
