package com.cpt.adventofcode;

import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import com.cpt.adventofcode.input.InputRetriever;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseTest<T> {

    protected void assertSolutionIsCorrect(Solution<T> solution, T expected) {
        AdventOfCodeSolutionResolver.SolutionInfo solutionInfo = AdventOfCodeSolutionResolver.resolve(solution);
        Stream<String> inputStream = getInputStream(solutionInfo.getYear(), solutionInfo.getDay());
        assertThat(solution.solve(inputStream)).isEqualTo(expected);
    }

    Stream<String> getInputStream(int year, int day) {
        return InputRetriever.retrieveInputStream(year, day, getClass());
    }

}
