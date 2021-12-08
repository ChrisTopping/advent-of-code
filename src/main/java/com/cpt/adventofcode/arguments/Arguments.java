package com.cpt.adventofcode.arguments;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Arguments {

    private final Map<ArgumentType, List<String>> argumentMap;

    public Arguments(String[] args) {
        argumentMap = Arrays.stream(args)
                .map(Argument::new)
                .collect(Collectors.toMap(Argument::getArgumentType, Argument::getValues, (first, second) -> first));
    }

    public Optional<List<String>> get(ArgumentType argumentType) {
        return Optional.ofNullable(argumentMap.get(argumentType));
    }

    public enum ArgumentType {
        YEAR,
        DAY,
        PART,
        TAGS,
        LATEST,
        ;

        public static ArgumentType of(String argumentTypeString) {
            try {
                return valueOf(argumentTypeString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Cannot parse argument type: " + argumentTypeString);
                System.exit(1);
                return null;
            }
        }
    }

    private static class Argument {
        @Getter
        private final ArgumentType argumentType;
        @Getter
        private List<String> values;

        public Argument(String argumentString) {
            String[] equalsSplit = argumentString.split("=");

            if (equalsSplit.length != 2) {
                System.out.println("Cannot parse argument: " + argumentString);
                System.exit(1);
            }

            argumentType = ArgumentType.of(equalsSplit[0]);

            try {
                String[] commaSplit = equalsSplit[1].split(",");
                values = Arrays.stream(commaSplit).collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("Cannot parse argument type: " + argumentString);
                System.exit(1);
            }
        }
    }

}
