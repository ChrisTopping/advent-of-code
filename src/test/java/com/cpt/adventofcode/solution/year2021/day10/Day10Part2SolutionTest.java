package com.cpt.adventofcode.solution.year2021.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 2")
class Day10Part2SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 288957")
    void givenTestInput_ShouldReturn288957() {
        Day10Part2Solution solution = new Day10Part2Solution();
        assertSolutionIsCorrect(solution, 288957L);
    }

}