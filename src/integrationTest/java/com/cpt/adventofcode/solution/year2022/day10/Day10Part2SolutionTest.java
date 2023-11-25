package com.cpt.adventofcode.solution.year2022.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 2")
class Day10Part2SolutionTest extends BaseTest<String> {

    @Test
    @DisplayName("Given test input: should return ##..##..##..##..##..##..##..##..##..##..")
    void givenTestInput_ShouldReturn##..##..##..##..##..##..##..##..##..##..() {
        Day10Part2Solution2022 solution = new Day10Part2Solution2022();
        assertSolutionIsCorrect(solution, ##..##..##..##..##..##..##..##..##..##..);
    }

}