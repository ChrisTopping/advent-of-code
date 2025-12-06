package com.cpt.adventofcode.solution.year2025.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 2")
class Day6Part2Solution2025IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 7669802156452")
    void givenTestInput_ShouldReturn7669802156452() {
        Day6Part2Solution2025 solution = new Day6Part2Solution2025();
        assertSolutionIsCorrect(solution, 7669802156452L);
    }

}