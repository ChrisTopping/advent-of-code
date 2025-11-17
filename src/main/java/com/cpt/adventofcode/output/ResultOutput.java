package com.cpt.adventofcode.output;

import lombok.*;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class ResultOutput<T> {

    private int year;
    private int day;
    private int part;
    private List<String> tags;

    private T value;
    private String durationNs;


}
