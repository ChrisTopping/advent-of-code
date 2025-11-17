package com.cpt.adventofcode.output;

public enum OutputType {
    DEFAULT,
    VERBOSE,
    JSON;

    public static OutputType fromString(String string) {
        for (OutputType outputType : OutputType.values()) {
            if (outputType.toString().equalsIgnoreCase(string)) {
                return outputType;
            }
        }

        return DEFAULT;
    }
}
