package com.cpt.adventofcode.solution.year2021.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 2")
class Day6Part2SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input, after 256 days: should return 26984457539")
    void givenTestInput_After256Days_ShouldReturn26984457539() {
        Day6Solution solution = new Day6Part2Solution();
        assertSolutionIsCorrect(solution, 26984457539L);
    }

}