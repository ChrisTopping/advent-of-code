package com.cpt.adventofcode.solution.year2025.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 2")
class Day5Part2Solution2025IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 350939902751909")
    void givenTestInput_ShouldReturn350939902751909() {
        Day5Part2Solution2025 solution = new Day5Part2Solution2025();
        assertSolutionIsCorrect(solution, 350939902751909L);
    }

}