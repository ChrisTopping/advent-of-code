package com.cpt.adventofcode.solution.year2023.day24;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 24 Part 1")
class Day24Part1Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day24Part1Solution2023 solution = new Day24Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}