package com.cpt.adventofcode.solution.year2023.day15;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 15 Part 1")
class Day15Part1Solution2023IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day15Part1Solution2023 solution = new Day15Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}