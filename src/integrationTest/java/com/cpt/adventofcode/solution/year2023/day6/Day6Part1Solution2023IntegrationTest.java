package com.cpt.adventofcode.solution.year2023.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 1")
class Day6Part1Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day6Part1Solution2023 solution = new Day6Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}