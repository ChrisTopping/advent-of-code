package com.cpt.adventofcode.solver;

import com.cpt.adventofcode.annotations.AdventOfCodeSolutionResolver;
import com.cpt.adventofcode.input.InputRetriever;
import com.cpt.adventofcode.result.Result;
import com.cpt.adventofcode.solution.Solution;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Solver {

    public <T> Result<T> solveAll(final Solution<T> solution) {
        AdventOfCodeSolutionResolver.SolutionInfo solutionInfo = AdventOfCodeSolutionResolver.resolve(solution);
        Stream<String> inputStream = InputRetriever.retrieveInputStream(solutionInfo.getYear(), solutionInfo.getDay(), getClass());

        LocalDateTime start = LocalDateTime.now();

        T resultValue = solution.solve(inputStream);

        LocalDateTime finish = LocalDateTime.now();
        Duration duration = Duration.between(start, finish);

        return new Result<>(resultValue, duration, solutionInfo);
    }
}
