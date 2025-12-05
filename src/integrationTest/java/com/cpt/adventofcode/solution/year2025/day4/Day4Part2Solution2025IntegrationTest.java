package com.cpt.adventofcode.solution.year2025.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 2")
class Day4Part2Solution2025IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 8887")
    void givenTestInput_ShouldReturn8887() {
        Day4Part2Solution2025 solution = new Day4Part2Solution2025();
        assertSolutionIsCorrect(solution, 8887);
    }

}