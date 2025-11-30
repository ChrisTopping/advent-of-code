package com.cpt.adventofcode.solution.year2015.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 1")
class Day10Part1Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 252594")
    void givenTestInput_ShouldReturn0() {
        Day10Part1Solution2015 solution = new Day10Part1Solution2015();
        assertSolutionIsCorrect(solution, 252594);
    }

}