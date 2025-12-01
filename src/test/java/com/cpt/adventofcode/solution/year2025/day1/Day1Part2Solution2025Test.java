package com.cpt.adventofcode.solution.year2025.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 2")
class Day1Part2Solution2025Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 6")
    void givenTestInput_ShouldReturn6() {
        Day1Part2Solution2025 solution = new Day1Part2Solution2025();
        assertSolutionIsCorrect(solution, 6);
    }

}