package com.cpt.adventofcode.input;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

public class InputRetriever {

    public static Stream<String> retrieveInputStream(int year, int day, Class<?> loadingClass) {
        String fileName = String.format("/input/year%d/day%d.txt", year, day);
        try {
            Path path = new File(Objects.requireNonNull(loadingClass.getResource(fileName)).getFile()).toPath();
            return Files.lines(path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve input stream", e);
        }
    }

}
