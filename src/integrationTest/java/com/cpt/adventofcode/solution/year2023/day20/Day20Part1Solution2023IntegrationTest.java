package com.cpt.adventofcode.solution.year2023.day20;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 20 Part 1")
class Day20Part1Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day20Part1Solution2023 solution = new Day20Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}