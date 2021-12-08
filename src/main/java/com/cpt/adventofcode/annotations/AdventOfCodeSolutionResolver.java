package com.cpt.adventofcode.annotations;

import com.cpt.adventofcode.solution.Solution;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.Annotation;

public class AdventOfCodeSolutionResolver {

    public static SolutionInfo resolve(Solution<?> solution) {
        Annotation[] annotations = solution.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> type = annotation.annotationType();
            if (type.equals(AdventOfCodeSolution.class)) {
                return SolutionInfo.builder()
                        .year(((AdventOfCodeSolution) annotation).year())
                        .day(((AdventOfCodeSolution) annotation).day())
                        .part(((AdventOfCodeSolution) annotation).part())
                        .description(((AdventOfCodeSolution) annotation).description())
                        .link(((AdventOfCodeSolution) annotation).link())
                        .tags(((AdventOfCodeSolution) annotation).tags())
                        .build();
            }
        }
        throw new RuntimeException("Solution must be annotated with AdventOfCodeSolution.class");
    }

    @RequiredArgsConstructor
    @Data
    @Builder
    public static class SolutionInfo {
        private final int year;
        private final int day;
        private final int part;
        private final String description;
        private final String link;
        private final String[] tags;
    }

}
