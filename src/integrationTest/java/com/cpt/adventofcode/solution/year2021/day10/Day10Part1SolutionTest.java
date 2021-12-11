package com.cpt.adventofcode.solution.year2021.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 1")
class Day10Part1SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 311895")
    void givenTestInput_ShouldReturn311895() {
        Day10Part1Solution solution = new Day10Part1Solution();
        assertSolutionIsCorrect(solution, 311895L);
    }

}