package com.cpt.adventofcode.solution.year2021.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 2")
class Day6Part2Solution2021Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input, after 80 days: should return 1738377086345")
    void givenTestInput_After256Days_ShouldReturn1738377086345() {
        Day6Solution solution = new Day6Part2Solution2021();
        assertSolutionIsCorrect(solution, 1738377086345L);
    }

}