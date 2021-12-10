package com.cpt.adventofcode;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import com.cpt.adventofcode.arguments.SolverArguments;
import com.cpt.adventofcode.result.Result;
import com.cpt.adventofcode.solution.Solution;
import com.cpt.adventofcode.solver.Solver;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SolverRunner {

    private static final Solver SOLVER = new Solver();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");

    public static void main(String[] args) {
        SolverArguments solverArguments = new SolverArguments(args);

        List<Solution<?>> solutions = findAllSolutions();
        List<Solution<?>> filteredSolutions = filterSolutions(solutions, solverArguments);

        System.out.println(MessageFormat.format("Solving {0} solutions:\n", filteredSolutions.size()));

        Set<Result<?>> results = filteredSolutions.stream()
                .sorted(solutionComparator())
                .map(SOLVER::solveAll)
                .sorted(resultComparator())
                .peek(result -> System.out.println(result.getPrintString()))
                .collect(Collectors.toSet());

        Duration totalDuration = results.stream()
                .map(Result::getDuration)
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);

        System.out.printf("%nTotal duration: %s seconds.%n", FORMATTER.format(totalDuration.addTo(LocalDateTime.MIN)));
    }

    private static List<Solution<?>> findAllSolutions() {
        Set<Class<?>> solutionClasses = new Reflections("com.cpt.adventofcode.solution").getTypesAnnotatedWith(AdventOfCodeSolution.class);
        return solutionClasses.stream()
                .filter(Solution.class::isAssignableFrom)
                .map(aClass -> {
                    try {
                        return (Solution<?>) aClass.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException("Unable to instantiate class");
                    }
                }).collect(Collectors.toList());
    }

    private static List<Solution<?>> filterSolutions(List<Solution<?>> solutions, SolverArguments solverArguments) {
        Optional<List<String>> latest = solverArguments.get(SolverArguments.SolverArgumentType.LATEST);

        return solutions.stream()
                .filter(yearFilter(solverArguments))
                .filter(dayFilter(solverArguments))
                .filter(partFilter(solverArguments))
                .filter(tagsFilter(solverArguments))
                .sorted(solutionComparator().reversed())
                .limit(latest.map(strings -> Long.parseLong(strings.get(0))).orElse(Long.MAX_VALUE))
                .collect(Collectors.toList());
    }

    private static Predicate<Solution<?>> yearFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> year = solverArguments.get(SolverArguments.SolverArgumentType.YEAR);
            return year.isEmpty() || year.get().contains(String.valueOf(getYear(solution)));
        };
    }

    private static Predicate<Solution<?>> dayFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> day = solverArguments.get(SolverArguments.SolverArgumentType.DAY);
            return day.isEmpty() || day.get().contains(String.valueOf(getDay(solution)));
        };
    }

    private static Predicate<Solution<?>> partFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> part = solverArguments.get(SolverArguments.SolverArgumentType.PART);
            return part.isEmpty() || part.get().contains(String.valueOf(getPart(solution)));
        };
    }

    private static Predicate<Solution<?>> tagsFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> part = solverArguments.get(SolverArguments.SolverArgumentType.TAGS);
            return part.isEmpty() || part.get().stream()
                    .anyMatch(s -> containsFilterWithInversion(getTags(solution)).test(s));
        };
    }

    private static Predicate<String> containsFilterWithInversion(String[] values) {
        return string -> string.startsWith("!") != Arrays.stream(values)
                .collect(Collectors.toList())
                .contains(string.replace("!", ""));
    }

    private static Comparator<Solution<?>> solutionComparator() {
        return Comparator
                .comparing(SolverRunner::getYear)
                .thenComparing(SolverRunner::getDay)
                .thenComparing(SolverRunner::getPart);
    }

    private static Comparator<Result<?>> resultComparator() {
        return Comparator.comparingInt(result -> {
            AdventOfCodeSolutionResolver.SolutionInfo solutionInfo = result.getSolutionInfo();
            return solutionInfo.getYear() * 4 + solutionInfo.getDay() * 2 + solutionInfo.getPart();
        });
    }

    private static String[] getTags(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getTags();
    }

    private static int getPart(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getPart();
    }

    private static int getDay(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getDay();
    }

    private static int getYear(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getYear();
    }

}
