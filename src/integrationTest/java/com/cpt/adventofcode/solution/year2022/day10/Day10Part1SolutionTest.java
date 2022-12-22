package com.cpt.adventofcode.solution.year2022.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 1")
class Day10Part1SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 11960")
    void givenTestInput_ShouldReturn11960() {
        Day10Part1Solution solution = new Day10Part1Solution();
        assertSolutionIsCorrect(solution, 11960L);
    }

}