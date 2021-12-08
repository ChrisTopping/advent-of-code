package com.cpt.adventofcode;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import com.cpt.adventofcode.arguments.Arguments;
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
import java.util.stream.Collectors;

public class SolverRunner {

    private static final Solver SOLVER = new Solver();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("s.SSS");

    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);

        List<Solution<?>> solutions = findAllSolutions();
        List<Solution<?>> filteredSolutions = filterSolutions(solutions, arguments);

        System.out.println(MessageFormat.format("Solving {0} solutions:\n", filteredSolutions.size()));

        Set<Result<?>> results = filteredSolutions.stream()
                .sorted(solutionComparator())
                .map(SOLVER::solveAll)
                .collect(Collectors.toSet());

        results.stream()
                .sorted(resultComparator())
                .map(Result::getPrintString)
                .forEach(System.out::println);

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
                })
                .collect(Collectors.toList());
    }

    private static List<Solution<?>> filterSolutions(List<Solution<?>> solutions, Arguments arguments) {
        Optional<List<String>> latest = arguments.get(Arguments.ArgumentType.LATEST);

        List<Solution<?>> filteredSolutions = solutions.stream()
                .filter(solution -> {
                    Optional<List<String>> year = arguments.get(Arguments.ArgumentType.YEAR);
                    return year.isEmpty() || year.get().contains(String.valueOf(getYear(solution)));
                }).filter(solution -> {
                    Optional<List<String>> day = arguments.get(Arguments.ArgumentType.DAY);
                    return day.isEmpty() || day.get().contains(String.valueOf(getDay(solution)));
                }).filter(solution -> {
                    Optional<List<String>> part = arguments.get(Arguments.ArgumentType.PART);
                    return part.isEmpty() || part.get().contains(String.valueOf(getPart(solution)));
                }).filter(solution -> {
                    Optional<List<String>> part = arguments.get(Arguments.ArgumentType.TAGS);
                    return part.isEmpty() || part.get().stream()
                            .anyMatch(s -> Arrays.stream(getTags(solution))
                                    .collect(Collectors.toList()).contains(s));
                }).sorted(solutionComparator().reversed())
                .limit(latest.map(strings -> Long.parseLong(strings.get(0))).orElse(Long.MAX_VALUE))
                .collect(Collectors.toList());

        return filteredSolutions;
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
