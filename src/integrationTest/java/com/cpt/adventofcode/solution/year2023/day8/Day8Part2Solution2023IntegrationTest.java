package com.cpt.adventofcode.solution.year2023.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 8 Part 2")
class Day8Part2Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day8Part2Solution2023 solution = new Day8Part2Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}