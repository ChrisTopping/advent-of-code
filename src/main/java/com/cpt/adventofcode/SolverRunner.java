package com.cpt.adventofcode;

import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver.SolutionInfo;
import com.cpt.adventofcode.arguments.SolverArguments;
import com.cpt.adventofcode.result.Result;
import com.cpt.adventofcode.solution.Solution;
import com.cpt.adventofcode.solver.SolutionRetriever;
import com.cpt.adventofcode.solver.Solver;
import com.diogonunes.jcolor.AnsiFormat;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.cpt.adventofcode.arguments.SolverArguments.SolverArgumentType.*;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class SolverRunner {

    private static final Solver SOLVER = new Solver();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");

    public static void main(String[] args) {
        SolverArguments solverArguments = new SolverArguments(args);

        List<Solution<?>> solutions = new SolutionRetriever().retrieveSolutions(solverArguments);
        System.out.println(MessageFormat.format("Solving {0} solutions:", solutions.size()));

        List<Result<?>> results = solveSolutions(solutions, getAveragingIterations(solverArguments), isFastest(solverArguments));

        if (!isVerbose(solverArguments)) System.out.println(Result.getLaconicHeaders());
        results.forEach(result -> printResult(isVerbose(solverArguments), getMaxDuration(results), result));

        Duration totalDuration = getTotalDuration(results);
        System.out.printf("%nSolved %d solutions with a total duration: %s seconds.%n", results.size(), FORMATTER.format(totalDuration.addTo(LocalDateTime.MIN)));
    }

    private static boolean isFastest(SolverArguments solverArguments) {
        return solverArguments.get(FASTEST)
                .map(strings -> strings.get(0))
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    private static Integer getAveragingIterations(SolverArguments solverArguments) {
        return solverArguments.get(AVERAGE)
                .map(strings -> strings.get(0))
                .map(Integer::parseInt)
                .orElse(1);
    }

    private static List<Result<?>> solveSolutions(List<Solution<?>> solutions, int averagingIterations, boolean fastest) {
        if (fastest) {
            Map<SolutionInfo, List<Result<?>>> resultsMap = solutions.stream()
                    .map((Solution<?> solution) -> solveSolution(solution, averagingIterations))
                    .collect(Collectors.groupingBy(Result::getSolutionInfo));

            return resultsMap.values().stream()
                    .map(results -> results.stream().min(Comparator.comparing(Result::getDuration)).orElse(null))
                    .filter(Objects::nonNull)
                    .sorted(SolverRunner::resultComparator)
                    .collect(Collectors.toList());
        } else {
            return solutions.stream()
                    .map(solution -> solveSolution(solution, averagingIterations))
                    .collect(Collectors.toList());
        }
    }

    private static long getMaxDuration(List<Result<?>> results) {
        return results.stream()
                .map(Result::getDuration)
                .mapToLong(Duration::toMillis)
                .max().orElse(0);
    }

    private static Result<?> solveSolution(Solution<?> solution, Integer averagingIterations) {
        List<Result<?>> solutionResults = new ArrayList<>();
        for (int iteration = 0; iteration < averagingIterations; iteration++) {
            solutionResults.add(SOLVER.solveAll(solution));
        }

        double averageDuration = solutionResults.stream()
                .map(Result::getDuration)
                .mapToLong(Duration::toMillis)
                .filter(value -> value != 0)
                .average()
                .orElse(0);

        Result<?> result = solutionResults.get(0);
        result.setDuration(Duration.ofMillis((long) averageDuration));
        return result;
    }

    private static int resultComparator(Result<?> left, Result<?> right) {
        return Comparator.comparing(SolutionInfo::getYear)
                .thenComparing(SolutionInfo::getDay)
                .thenComparing(SolutionInfo::getPart)
                .compare(left.getSolutionInfo(), right.getSolutionInfo());
    }

    private static Boolean isVerbose(SolverArguments solverArguments) {
        return solverArguments.get(VERBOSE)
                .map(strings -> strings.get(0))
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    private static void printResult(Boolean verbose, long maxDuration, Result<?> result) {
        double relativeDuration = 1.0 * result.getDuration().toMillis() / maxDuration;
        int red = (int) (255 * relativeDuration);
        int green = (int) (255 * (1 - relativeDuration));
        System.out.println(verbose ? result.getVerbosePrintString() : result.getLaconicPrintString(new AnsiFormat(TEXT_COLOR(red, green, 0))));
    }

    private static Duration getTotalDuration(List<Result<?>> results) {
        return results.stream()
                .map(Result::getDuration)
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);
    }

}
