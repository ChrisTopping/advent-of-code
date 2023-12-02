package com.cpt.adventofcode.arguments;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScraperArguments {

    private final Map<ScraperArguments.ScraperArgumentType, List<String>> argumentMap;

    public ScraperArguments(String[] args) {
        argumentMap = Arrays.stream(args)
                .map(ScraperArguments.ScraperArgument::new)
                .collect(Collectors.toMap(ScraperArguments.ScraperArgument::getScraperArgumentType, ScraperArguments.ScraperArgument::getValues, (first, second) -> first));
    }

    public Optional<List<String>> get(ScraperArguments.ScraperArgumentType scraperArgumentType) {
        return Optional.ofNullable(argumentMap.get(scraperArgumentType));
    }

    public String getFirst(ScraperArguments.ScraperArgumentType scraperArgumentType) {
        if (argumentMap.containsKey(scraperArgumentType) && argumentMap.get(scraperArgumentType).size() > 0) {
            return argumentMap.get(scraperArgumentType).get(0);
        } else {
            throw new RuntimeException("Invalid argument provided for type " + scraperArgumentType.name());
        }
    }

    public boolean has(ScraperArguments.ScraperArgumentType... scraperArgumentTypes) {
        return Arrays.stream(scraperArgumentTypes).allMatch(argumentMap::containsKey);
    }

    public enum ScraperArgumentType {
        YEAR,
        DAY,
        TODAY,
        TYPE;

        public static ScraperArguments.ScraperArgumentType of(String argumentTypeString) {
            try {
                return valueOf(argumentTypeString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Cannot parse argument type: " + argumentTypeString);
                System.exit(1);
                return null;
            }
        }
    }

    private static class ScraperArgument {
        @Getter
        private final ScraperArguments.ScraperArgumentType scraperArgumentType;
        @Getter
        private List<String> values;

        public ScraperArgument(String argumentString) {
            String[] equalsSplit = argumentString.split("=");

            if (equalsSplit.length != 2) {
                System.out.println("Cannot parse argument: " + argumentString);
                System.exit(1);
            }

            scraperArgumentType = ScraperArguments.ScraperArgumentType.of(equalsSplit[0]);

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
