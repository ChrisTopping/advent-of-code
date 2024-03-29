package com.cpt.adventofcode.solution.year2023.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part1Solution2023IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1934898178")
    void givenTestInput_ShouldReturn0() {
        Day9Part1Solution2023 solution = new Day9Part1Solution2023();
        assertSolutionIsCorrect(solution, 1934898178L);
    }

}