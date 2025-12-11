package com.cpt.adventofcode.solution.year2025.day11;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 11 Part 2")
class Day11Part2Solution2025Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day11Part2Solution2025 solution = new Day11Part2Solution2025();
        assertSolutionIsCorrect(solution, 0);
    }

}