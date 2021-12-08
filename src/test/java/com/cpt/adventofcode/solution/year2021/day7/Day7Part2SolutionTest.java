package com.cpt.adventofcode.solution.year2021.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day7Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 168")
    void givenTestInput_ShouldReturn37() {
        Day7Part2Solution solution = new Day7Part2Solution();
        assertSolutionIsCorrect(solution, 168);
    }

}