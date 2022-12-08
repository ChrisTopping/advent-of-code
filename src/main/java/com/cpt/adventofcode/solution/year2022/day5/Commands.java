package com.cpt.adventofcode.solution.year2022.day5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Commands {
    private final List<Command> commands;


    public static Commands fromStrings(List<String> commandStrings) {
        List<Command> commands = commandStrings.stream()
                .map(Command::fromString)
                .collect(Collectors.toList());

        return new Commands(commands);

    }
}
