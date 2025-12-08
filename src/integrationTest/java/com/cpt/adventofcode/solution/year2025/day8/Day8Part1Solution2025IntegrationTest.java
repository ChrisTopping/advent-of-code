package com.cpt.adventofcode.solution.year2025.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 8 Part 1")
class Day8Part1Solution2025IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day8Part1Solution2025 solution = new Day8Part1Solution2025();
        assertSolutionIsCorrect(solution, 0);
    }

}