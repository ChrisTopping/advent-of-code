package com.cpt.adventofcode.solution.year2015.day6;

import com.cpt.adventofcode.helpers.Strings;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Instruction {
    private final Action action;
    private final Coordinate start;
    private final Coordinate end;

    public Instruction(String input) {
        action = Action.fromString(input);
        List<Coordinate> coords = Strings
                .splitAndCast(input.replace(action.getString(), "").trim(), " through ", Strings.Type.STRING)
                .stream()
                .map(o -> new Coordinate((String) o))
                .collect(Collectors.toList());
        start = coords.get(0);
        end = coords.get(1);
    }

}
