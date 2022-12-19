package com.cpt.adventofcode.solution.year2022.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 8 Part 2")
class Day8Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 595080")
    void givenTestInput_ShouldReturn595080() {
        Day8Part2Solution solution = new Day8Part2Solution();
        assertSolutionIsCorrect(solution, 595080);
    }

}