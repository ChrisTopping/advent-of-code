package com.cpt.adventofcode.solution.year2015.day6;

import lombok.Getter;

import java.util.Arrays;

@Getter
enum Action {
    TURN_ON("turn on"),
    TURN_OFF("turn off"),
    TOGGLE("toggle");

    private String string;

    Action(String string) {
        this.string = string;
    }

    public static Action fromString(String input) {
        return Arrays
                .stream(values())
                .filter(a -> input.contains(a.string))
                .findFirst()
                .orElseThrow();
    }
}
