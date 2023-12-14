package com.cpt.adventofcode.solution.year2023.day14;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 14 Part 1")
class Day14Part1Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day14Part1Solution2023 solution = new Day14Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}