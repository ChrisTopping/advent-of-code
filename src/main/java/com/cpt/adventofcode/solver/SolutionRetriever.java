package com.cpt.adventofcode.solver;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import com.cpt.adventofcode.arguments.SolverArguments;
import com.cpt.adventofcode.solution.Solution;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SolutionRetriever {

    public List<Solution<?>> retrieveSolutions(SolverArguments arguments) {
        Optional<Long> latestValue = arguments.get(SolverArguments.SolverArgumentType.LATEST)
                .map(strings -> Long.parseLong(strings.get(0)));

        boolean reverse = latestValue.map(value -> value >= 0)
                .orElse(true);

        Set<Class<?>> solutionClasses = new Reflections("com.cpt.adventofcode.solution").getTypesAnnotatedWith(AdventOfCodeSolution.class);
        return solutionClasses.stream()
                .filter(Solution.class::isAssignableFrom)
                .map(aClass -> {
                    try {
                        return (Solution<?>) aClass.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException("Unable to instantiate class");
                    }
                }).filter(filterByArguments(arguments))
                .sorted((o1, o2) -> reverse ? solutionComparator(o2, o1) : solutionComparator(o1, o2)) // reverse order to get latest
                .limit(Math.abs(latestValue.orElse(Long.MAX_VALUE)))
                .sorted(this::solutionComparator)
                .collect(Collectors.toList());
    }

    private int solutionComparator(Solution<?> left, Solution<?> right) {
        return Comparator
                .comparing(this::getYear)
                .thenComparing(this::getDay)
                .thenComparing(this::getPart)
                .compare(left, right);
    }

    private Predicate<? super Solution<?>> filterByArguments(SolverArguments arguments) {
        return yearFilter(arguments)
                .and(dayFilter(arguments))
                .and(partFilter(arguments))
                .and(tagsFilter(arguments));
    }

    private Predicate<Solution<?>> yearFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> year = solverArguments.get(SolverArguments.SolverArgumentType.YEAR);
            return year.isEmpty() || year.get().contains(String.valueOf(getYear(solution)));
        };
    }

    private Predicate<Solution<?>> dayFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> day = solverArguments.get(SolverArguments.SolverArgumentType.DAY);
            return day.isEmpty() || day.get().contains(String.valueOf(getDay(solution)));
        };
    }

    private Predicate<Solution<?>> partFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> part = solverArguments.get(SolverArguments.SolverArgumentType.PART);
            return part.isEmpty() || part.get().contains(String.valueOf(getPart(solution)));
        };
    }

    private Predicate<Solution<?>> tagsFilter(SolverArguments solverArguments) {
        return solution -> {
            Optional<List<String>> part = solverArguments.get(SolverArguments.SolverArgumentType.TAGS);
            return part.isEmpty() || part.get().stream()
                    .anyMatch(s -> containsFilterWithInversion(getTags(solution)).test(s));
        };
    }

    private Predicate<String> containsFilterWithInversion(String[] values) {
        return string -> string.startsWith("!") != Arrays.stream(values)
                .collect(Collectors.toList())
                .contains(string.replace("!", ""));
    }

    private String[] getTags(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getTags();
    }

    private int getPart(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getPart();
    }

    private int getDay(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getDay();
    }

    private int getYear(Solution<?> solution) {
        return AdventOfCodeSolutionResolver.resolve(solution).getYear();
    }
}
