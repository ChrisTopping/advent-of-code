package com.cpt.adventofcode.solution.year2022.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 2")
class Day9Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 2514")
    void givenTestInput_ShouldReturn2514() {
        Day9Part2Solution solution = new Day9Part2Solution();
        assertSolutionIsCorrect(solution, 2514);
    }

}