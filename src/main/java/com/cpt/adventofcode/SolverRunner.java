package com.cpt.adventofcode;

import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver.SolutionInfo;
import com.cpt.adventofcode.arguments.SolverArguments;
import com.cpt.adventofcode.output.OutputProviderFactory;
import com.cpt.adventofcode.output.OutputType;
import com.cpt.adventofcode.result.Result;
import com.cpt.adventofcode.solution.Solution;
import com.cpt.adventofcode.solver.ReadmeUpdater;
import com.cpt.adventofcode.solver.SolutionRetriever;
import com.cpt.adventofcode.solver.Solver;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static com.cpt.adventofcode.arguments.SolverArguments.SolverArgumentType.*;

public class SolverRunner {

    private static final Solver SOLVER = new Solver();

    static void main(String[] args) throws IOException {
        SolverArguments solverArguments = new SolverArguments(args);

        List<Solution<?>> solutions = new SolutionRetriever().retrieveSolutions(solverArguments);
        System.out.println(MessageFormat.format("Solving {0} solutions:\n", solutions.size()));

        List<Result<?>> results = solveSolutions(solutions, getAveragingIterations(solverArguments), isFastest(solverArguments));

        OutputType outputType = getOutputType(solverArguments);
        String output = OutputProviderFactory.create(outputType).provide(results);
        System.out.println(output);

        Duration totalDuration = getTotalDuration(results);

        if (shouldUpdateReadme(solverArguments)) {
            ReadmeUpdater.replaceReadmeResults(outputType == OutputType.DEFAULT ? output : OutputProviderFactory.create(OutputType.DEFAULT).provide(results));
        }

        Double limit = getLimit(solverArguments);
        if (null != limit) {
            Duration limitInMillis = Duration.ofMillis((long) (limit * 1000));
            if (totalDuration.compareTo(limitInMillis) > 0) {
                System.out.printf("Solution time not within %s seconds limit", limit);
                System.exit(1);
            } else {
                System.out.printf("Solution time within %s seconds limit", limit);
            }
        }
    }

    private static boolean isFastest(SolverArguments solverArguments) {
        return solverArguments.get(FASTEST)
                .map(List::getFirst)
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    private static Double getLimit(SolverArguments solverArguments) {
        return solverArguments.get(LIMIT)
                .map(List::getFirst)
                .map(Double::parseDouble)
                .orElse(null);
    }

    private static Integer getAveragingIterations(SolverArguments solverArguments) {
        return solverArguments.get(AVERAGE)
                .map(List::getFirst)
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

    private static Result<?> solveSolution(Solution<?> solution, Integer averagingIterations) {
        List<Result<?>> solutionResults = new ArrayList<>();
        for (int iteration = 0; iteration < averagingIterations; iteration++) {
            solutionResults.add(SOLVER.solveAll(solution));
        }

        double averageDuration = solutionResults.stream()
                .map(Result::getDuration)
                .mapToLong(Duration::toNanos)
                .filter(value -> value != 0)
                .average()
                .orElse(0);

        Result<?> result = solutionResults.getFirst();
        result.setDuration(Duration.ofNanos((long) averageDuration));
        return result;
    }

    private static int resultComparator(Result<?> left, Result<?> right) {
        return Comparator.comparing(SolutionInfo::getYear)
                .thenComparing(SolutionInfo::getDay)
                .thenComparing(SolutionInfo::getPart)
                .compare(left.getSolutionInfo(), right.getSolutionInfo());
    }

    private static Boolean shouldUpdateReadme(SolverArguments solverArguments) {
        return solverArguments.get(README)
                .map(List::getFirst)
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    private static Duration getTotalDuration(List<Result<?>> results) {
        return results.stream()
                .map(Result::getDuration)
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);
    }

    private static OutputType getOutputType(SolverArguments solverArguments) {
        return solverArguments.get(OUTPUT)
                .map(List::getFirst)
                .map(OutputType::fromString)
                .orElse(OutputType.DEFAULT);
    }

}
