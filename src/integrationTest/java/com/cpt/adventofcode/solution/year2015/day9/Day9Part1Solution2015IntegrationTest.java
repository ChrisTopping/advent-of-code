package com.cpt.adventofcode.solution.year2015.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part1Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 141")
    void givenTestInput_ShouldReturn0() {
        Day9Part1Solution2015 solution = new Day9Part1Solution2015();
        assertSolutionIsCorrect(solution, 141);
    }

}