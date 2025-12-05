package com.cpt.adventofcode.solution.year2025.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 1")
class Day4Part1Solution2025IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1549")
    void givenTestInput_ShouldReturn1549() {
        Day4Part1Solution2025 solution = new Day4Part1Solution2025();
        assertSolutionIsCorrect(solution, 1549);
    }

}