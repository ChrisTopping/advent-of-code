package com.cpt.adventofcode.solution.year2025.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day7Part2Solution2025IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day7Part2Solution2025 solution = new Day7Part2Solution2025();
        assertSolutionIsCorrect(solution, 0);
    }

}