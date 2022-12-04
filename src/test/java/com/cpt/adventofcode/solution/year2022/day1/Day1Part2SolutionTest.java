package com.cpt.adventofcode.solution.year2022.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 2")
class Day1Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 45000")
    void givenTestInput_ShouldReturn45000() {
        Day1Part2Solution solution = new Day1Part2Solution();
        assertSolutionIsCorrect(solution, 45000);
    }

}