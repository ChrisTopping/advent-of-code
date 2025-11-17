package com.cpt.adventofcode.output;

public class OutputProviderFactory {

    public static OutputProvider create(OutputType type) {
        return switch (type) {
            case DEFAULT -> new DefaultOutputProvider();
            case VERBOSE -> new VerboseOutputProvider();
            case JSON -> new JsonOutputProvider();
        };
    }

}
