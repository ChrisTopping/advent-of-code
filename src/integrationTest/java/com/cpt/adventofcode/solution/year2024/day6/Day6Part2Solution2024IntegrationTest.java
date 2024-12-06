package com.cpt.adventofcode.solution.year2024.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 2")
class Day6Part2Solution2024IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day6Part2Solution2024 solution = new Day6Part2Solution2024();
        assertSolutionIsCorrect(solution, 0);
    }

}