package com.cpt.adventofcode.solution.year2025.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 1")
class Day5Part1Solution2025IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 511")
    void givenTestInput_ShouldReturn511() {
        Day5Part1Solution2025 solution = new Day5Part1Solution2025();
        assertSolutionIsCorrect(solution, 511);
    }

}