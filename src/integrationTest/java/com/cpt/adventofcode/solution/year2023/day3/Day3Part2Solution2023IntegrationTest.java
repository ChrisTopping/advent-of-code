package com.cpt.adventofcode.solution.year2023.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 2")
class Day3Part2Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day3Part2Solution2023 solution = new Day3Part2Solution2023();
        assertSolutionIsCorrect(solution, 76504829);
    }

}