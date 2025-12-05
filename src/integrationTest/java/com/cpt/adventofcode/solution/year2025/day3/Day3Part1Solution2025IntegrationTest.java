package com.cpt.adventofcode.solution.year2025.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 1")
class Day3Part1Solution2025IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 17427")
    void givenTestInput_ShouldReturn17427() {
        Day3Part1Solution2025 solution = new Day3Part1Solution2025();
        assertSolutionIsCorrect(solution, 17427);
    }

}