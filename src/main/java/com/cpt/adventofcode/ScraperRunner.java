package com.cpt.adventofcode;

import com.cpt.adventofcode.arguments.GeneratorArguments;
import com.cpt.adventofcode.arguments.ScraperArguments;
import com.cpt.adventofcode.generator.Generator;
import com.cpt.adventofcode.scraper.InputScraper;
import com.cpt.adventofcode.scraper.ProblemScraper;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cpt.adventofcode.arguments.GeneratorArguments.GeneratorArgumentType.*;
import static com.cpt.adventofcode.arguments.GeneratorArguments.GeneratorArgumentType.DAY;
import static com.cpt.adventofcode.arguments.GeneratorArguments.GeneratorArgumentType.YEAR;

public class ScraperRunner {

    public static void main(String[] args) throws IOException {
        ScraperArguments arguments = new ScraperArguments(args);

        String year, day;

        if (arguments.has(ScraperArguments.ScraperArgumentType.TODAY)) {
            LocalDate today = LocalDate.now();
            year = String.valueOf(today.getYear());
            day = String.valueOf(today.getDayOfMonth());
        }  else if (arguments.has(ScraperArguments.ScraperArgumentType.YEAR, ScraperArguments.ScraperArgumentType.DAY)) {
            year = arguments.getFirst(ScraperArguments.ScraperArgumentType.YEAR);
            day = arguments.getFirst(ScraperArguments.ScraperArgumentType.DAY);
        } else {
            throw new RuntimeException("Please provide arguments: either [year, day] or [today]");
        }

        // if solution files already exist, throw exception before scraping website
        throwIfSolutionExists(year, day);

        String description = ProblemScraper.getProblemDescription(year, day);
        Stream<String> input = InputScraper.getInput(year, day);

        String type = arguments.has(ScraperArguments.ScraperArgumentType.TYPE) ? arguments.getFirst(ScraperArguments.ScraperArgumentType.TYPE) : "Integer";

        generateSolutions(year, day, description, type, input);
    }

    private static void generateSolutions(String year, String day, String description, String type, Stream<String> input) {
        Generator generator = new Generator();

        GeneratorArguments generatorArguments = new GeneratorArguments()
                .put(YEAR, String.valueOf(year))
                .put(DAY, String.valueOf(day))
                .put(PART, "1")
                .put(DESCRIPTION, description)
                .put(LINK, String.format("https://adventofcode.com/%s/day/%s", year, day))
                .put(TAGS, "")
                .put(RESPONSE_TYPE, type)
                .put(TEST_INPUT, "")
                .put(TEST_RESPONSE, "0")
                .put(INPUT, input.collect(Collectors.joining("\n")));

        generator.generate(generatorArguments);

        generatorArguments
                .put(LINK, String.format("https://adventofcode.com/%s/day/%s#part2", year, day))
                .put(PART, "2");

        generator.generate(generatorArguments);
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
}
