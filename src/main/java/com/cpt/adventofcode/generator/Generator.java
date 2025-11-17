package com.cpt.adventofcode.generator;

import com.cpt.adventofcode.arguments.GeneratorArguments;
import com.cpt.adventofcode.arguments.GeneratorArguments.GeneratorArgumentType;
import com.google.common.io.Files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static com.cpt.adventofcode.arguments.GeneratorArguments.GeneratorArgumentType.*;

public class Generator {

    public void generate(GeneratorArguments arguments) {
        try {
            int year = Integer.parseInt(arguments.get(YEAR));
            int day = Integer.parseInt(arguments.get(DAY));
            int part = Integer.parseInt(arguments.get(PART));
            String solutionContent = replaceArguments(getResourceContent("solution.txt"), arguments);
            String solutionTestContent = replaceArguments(getResourceContent("solution-test.txt"), arguments);
            String solutionIntegrationTestContent = replaceArguments(getResourceContent("solution-integration-test.txt"), arguments);

            createSolutionFile(year, day, part, solutionContent);
            createTestFile(year, day, part, solutionTestContent);
            createIntegrationTestFile(year, day, part, solutionIntegrationTestContent);
            createInput(year, day, arguments.get(INPUT));
            createTestInput(year, day, arguments.get(TEST_INPUT));
        } catch (IOException e) {
            throw new RuntimeException("Unable to generate files", e);
        }
    }

    private String replaceArguments(String content, GeneratorArguments arguments) {
        for (Map.Entry<GeneratorArgumentType, String> entry : arguments.entries()) {
            content = content.replace("{" + entry.getKey().toString() + "}", entry.getValue());
        }
        return content;
    }

    private String getResourceContent(String filename) throws IOException {
        Path path = getRelativePath("src", "main", "resources", "generator", filename);
        return String.join("\n", Files.readLines(path.toFile(), Charset.defaultCharset()));
    }

    private static Path getRelativePath(String... subpaths) {
        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        return Paths.get(root.toString(), subpaths);
    }

    private void createSolutionFile(int year, int day, int part, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "main", "java", "com", "cpt", "adventofcode", "solution", "year" + year, "day" + day);
        Path filePath = Paths.get(directoryPath.toString(), "Day" + day + "Part" + part + "Solution" +  year + ".java");
        createFile(content, filePath);
    }

    private void createTestFile(int year, int day, int part, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "test", "java", "com", "cpt", "adventofcode", "solution", "year" + year, "day" + day);
        Path filePath = Paths.get(directoryPath.toString(), "Day" + day + "Part" + part + "Solution" +  year + "Test.java");
        createFile(content, filePath);
    }

    private void createIntegrationTestFile(int year, int day, int part, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "integrationTest", "java", "com", "cpt", "adventofcode", "solution", "year" + year, "day" + day);
        Path filePath = Paths.get(directoryPath.toString(), "Day" + day + "Part" + part + "Solution" + year + "IntegrationTest.java");
        createFile(content, filePath);
    }

    private void createInput(int year, int day, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "main", "resources", "input", "year" + year);
        Path filePath = Paths.get(directoryPath.toString(), "day" + day + ".txt");
        createFile(content, filePath);
    }

    private void createTestInput(int year, int day, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "test", "resources", "input", "year" + year);
        Path filePath = Paths.get(directoryPath.toString(), "day" + day + ".txt");
        createFile(content, filePath);
    }

    private void createFile(String content, Path filePath) throws IOException {
        if (!filePath.toFile().exists()) {
            Files.createParentDirs(filePath.toFile());
            Files.touch(filePath.toFile());
            Files.write(content.getBytes(), filePath.toFile());
        }
    }
}
