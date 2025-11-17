package com.cpt.adventofcode.arguments;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolverArguments {

    private final Map<SolverArgumentType, List<String>> argumentMap;

    public SolverArguments(String[] args) {
        argumentMap = Arrays.stream(args)
                .map(SolverArgument::new)
                .collect(Collectors.toMap(SolverArgument::getSolverArgumentType, SolverArgument::getValues, (first, _) -> first));
    }

    public Optional<List<String>> get(SolverArgumentType solverArgumentType) {
        return Optional.ofNullable(argumentMap.get(solverArgumentType));
    }

    public enum SolverArgumentType {
        YEAR,
        DAY,
        PART,
        TAGS,
        LATEST,
        VERBOSE,
        AVERAGE,
        FASTEST,
        LIMIT,
        README,
        OUTPUT
        ;

        public static SolverArgumentType of(String argumentTypeString) {
            try {
                return valueOf(argumentTypeString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Cannot parse argument type: " + argumentTypeString);
                System.exit(1);
                return null;
            }
        }
    }

    private static class SolverArgument {
        @Getter
        private final SolverArgumentType solverArgumentType;
        @Getter
        private List<String> values;

        public SolverArgument(String argumentString) {
            String[] equalsSplit = argumentString.split("=");

            if (equalsSplit.length != 2) {
                System.out.println("Cannot parse argument: " + argumentString);
                System.exit(1);
            }

            solverArgumentType = SolverArgumentType.of(equalsSplit[0]);

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
