package com.cpt.adventofcode;

import com.cpt.adventofcode.arguments.GeneratorArguments;
import com.cpt.adventofcode.arguments.ScraperArguments;
import com.cpt.adventofcode.generator.Generator;
import com.cpt.adventofcode.scraper.InputScraper;
import com.cpt.adventofcode.scraper.ProblemScraper;
import com.diogonunes.jcolor.AnsiFormat;
import com.google.common.io.Files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.cpt.adventofcode.arguments.GeneratorArguments.GeneratorArgumentType.*;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class ScraperRunner {

    public static void main(String[] args) throws IOException {
        ScraperArguments arguments = new ScraperArguments(args);

        if (arguments.has(ScraperArguments.ScraperArgumentType.EXAMPLE)) {
            scrapeExamples(arguments);
        } else if (arguments.has(ScraperArguments.ScraperArgumentType.INPUT)) {
            scrapeInput(arguments);
        } else {
            scrapeProblem(arguments);
        }
    }

    private static void scrapeExamples(ScraperArguments arguments) throws IOException {
        String year = getYear(arguments);
        String day = getDay(arguments);

        List<String> exampleInputs = ProblemScraper.getExampleInputs(year, day);

        AnsiFormat codeBlockFormat = new AnsiFormat(TEXT_COLOR(100, 255, 100));

        System.out.println("Code blocks in problem:\n");
        IntStream.range(0, exampleInputs.size())
                .mapToObj(i -> String.format("Code block %d:\n\n%s\n", i + 1, colorize(exampleInputs.get(i), codeBlockFormat)))
                .forEach(System.out::println);

        System.out.print("Code block to be used for example input: ");
        Scanner scanner = new Scanner(System.in);
        int exampleIndex = scanner.nextInt();

        System.out.printf("Setting example input to code block %d:\n%s\n%n", exampleIndex, exampleInputs.get(exampleIndex - 1));

        createTestInput(year, day, exampleInputs.get(exampleIndex - 1));
    }

    private static void scrapeInput(ScraperArguments arguments) throws IOException {
        String year = getYear(arguments);
        String day = getDay(arguments);
        Stream<String> input = InputScraper.getInput(year, day);

        String content = input.collect(Collectors.joining("\n"));
        createInput(year, day, content);
    }

    private static void scrapeProblem(ScraperArguments arguments) throws IOException {
        String year = getYear(arguments);
        String day = getDay(arguments);

        // if solution files already exist, throw exception before scraping website
        throwIfSolutionExists(year, day);

        String description = ProblemScraper.getDescription(year, day);
        Stream<String> input = InputScraper.getInput(year, day);

        String type = arguments.has(ScraperArguments.ScraperArgumentType.TYPE)
                ? arguments.getFirst(ScraperArguments.ScraperArgumentType.TYPE)
                : "Integer";

        generateSolutions(year, day, description, type, input);
    }

    private static String getYear(ScraperArguments arguments) {
        if (arguments.has(ScraperArguments.ScraperArgumentType.TODAY)) {
            LocalDate today = LocalDate.now();
            return String.valueOf(today.getYear());
        } else if (arguments.has(ScraperArguments.ScraperArgumentType.YEAR)) {
            return arguments.getFirst(ScraperArguments.ScraperArgumentType.YEAR);
        } else {
            throw new RuntimeException("Please provide arguments: either [year, day] or [today]");
        }
    }

    private static String getDay(ScraperArguments arguments) {
        if (arguments.has(ScraperArguments.ScraperArgumentType.TODAY)) {
            LocalDate today = LocalDate.now();
            return String.valueOf(today.getDayOfMonth());
        } else if (arguments.has(ScraperArguments.ScraperArgumentType.DAY)) {
            return arguments.getFirst(ScraperArguments.ScraperArgumentType.DAY);
        } else {
            throw new RuntimeException("Please provide arguments: either [year, day] or [today]");
        }
    }

    private static void throwIfSolutionExists(String year, String day) {
        if (getRelativePath("src", "main", "resources", "year" + year, "day" + day + ".txt").toFile().exists()) {
            throw new RuntimeException(String.format("Cannot generate solution for year %s day %s as solution already exists", year, day));
        }
    }

    private static Path getRelativePath(String... subpaths) {
        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        return Paths.get(root.toString(), subpaths);
    }

    private static void generateSolutions(String year, String day, String description, String type, Stream<String> input) {
        Generator generator = new Generator();

        String testResponse = switch (type.toLowerCase()) {
            case "string" -> "";
            case "long" -> "0L";
            case "double" -> "0D";
            case "float" -> "0F";
            case "boolean" -> "true";
            default -> "0";
        };

        GeneratorArguments generatorArguments = new GeneratorArguments()
                .put(YEAR, String.valueOf(year))
                .put(DAY, String.valueOf(day))
                .put(PART, "1")
                .put(DESCRIPTION, description)
                .put(LINK, String.format("https://adventofcode.com/%s/day/%s", year, day))
                .put(TAGS, "unsolved")
                .put(RESPONSE_TYPE, type)
                .put(TEST_INPUT, "")
                .put(TEST_RESPONSE, testResponse)
                .put(INPUT, input.collect(Collectors.joining("\n")));

        generator.generate(generatorArguments);

        generatorArguments
                .put(LINK, String.format("https://adventofcode.com/%s/day/%s#part2", year, day))
                .put(PART, "2");

        generator.generate(generatorArguments);
    }

    private static void createTestInput(String year, String day, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "test", "resources", "input", "year" + year);
        Path filePath = Paths.get(directoryPath.toString(), "day" + day + ".txt");
        createFile(content, filePath);
    }

    private static void createInput(String year, String day, String content) throws IOException {
        Path directoryPath = getRelativePath("src", "main", "resources", "input", "year" + year);
        Path filePath = Paths.get(directoryPath.toString(), "day" + day + ".txt");
        createFile(content, filePath);
    }


    private static void createFile(String content, Path filePath) throws IOException {
        if (!filePath.toFile().exists()) {
            System.out.println("Creating new example input at " + filePath + " ");
            Files.createParentDirs(filePath.toFile());
            Files.touch(filePath.toFile());
            Files.write(content.getBytes(), filePath.toFile());
        } else {
            System.out.println("Overwriting example input at " + filePath + " ");
            Files.write(content.getBytes(), filePath.toFile());
        }
    }
}
