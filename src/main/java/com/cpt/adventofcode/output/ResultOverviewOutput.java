package com.cpt.adventofcode.output;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class ResultOverviewOutput {
    private String language;

    private List<ResultOutput<Object>> results;
}
