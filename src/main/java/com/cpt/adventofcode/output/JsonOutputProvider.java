package com.cpt.adventofcode.output;

import com.cpt.adventofcode.result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class JsonOutputProvider implements OutputProvider {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("n");
    private static final ObjectMapper om = new ObjectMapper();

    @Override
    public String provide(List<Result<?>> results) {
        List<ResultOutput<Object>> resultOutputs = results.stream()
                .map(result -> ResultOutput.builder()
                        .year(result.getSolutionInfo().getYear())
                        .day(result.getSolutionInfo().getDay())
                        .part(result.getSolutionInfo().getPart())
                        .tags(Arrays.asList(result.getSolutionInfo().getTags()))
                        .value(result.getValue())
                        .durationNs(FORMATTER.format(result.getDuration().addTo(LocalDateTime.MIN)))
                        .build()
                ).toList();

        ResultOverviewOutput resultOverviewOutput = ResultOverviewOutput.builder()
                .language("Java")
                .results(resultOutputs)
                .build();

        try {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(resultOverviewOutput);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
