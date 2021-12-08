package com.cpt.adventofcode.solution.year2021.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 1")
class Day6Part1SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input, after 18 days: should return 387413")
    void givenTestInput_After80Days_Should1738377086345() {
        Day6Solution solution = new Day6Part1Solution();
        assertSolutionIsCorrect(solution, 387413L);
    }

}