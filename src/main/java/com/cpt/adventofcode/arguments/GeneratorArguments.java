package com.cpt.adventofcode.arguments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class GeneratorArguments {

    private final Map<GeneratorArgumentType, String> argumentMap = new HashMap<>();

    public void put(GeneratorArgumentType type, String value) {
        argumentMap.put(type, value);
    }

    public String get(GeneratorArgumentType type) {
        return argumentMap.get(type);
    }

    public Stream<Map.Entry<GeneratorArgumentType, String>> stream() {
        return argumentMap.entrySet().stream();
    }

    public Set<Map.Entry<GeneratorArgumentType, String>> entries() {
        return argumentMap.entrySet();
    }

    @AllArgsConstructor
    public enum GeneratorArgumentType {
        YEAR(0, "Year", false),
        DAY(1, "Day", false),
        PART(2, "Part", false),
        DESCRIPTION(3, "Description", false),
        LINK(4, "Link", false),
        TAGS(5, "Tags", false),
        RESPONSE_TYPE(6, "Response type", false),
        TEST_INPUT(7, "Test input", true),
        TEST_RESPONSE(8, "Test response", false),
        INPUT(9, "Input", true),
        ;

        @Getter
        private int ordinal;
        @Getter
        private String name;
        @Getter
        private boolean multiline;

//        public static GeneratorArgumentType of(String argumentTypeString) {
//            try {
//                return valueOf(argumentTypeString.toUpperCase());
//            } catch (IllegalArgumentException e) {
//                System.out.println("Cannot parse argument type: " + argumentTypeString);
//                System.exit(1);
//                return null;
//            }
//        }
    }

}
