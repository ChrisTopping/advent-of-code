package com.cpt.adventofcode.solution.year2021.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 2")
class Day5Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 12")
    void givenTestInput_ShouldReturn12() {
        Day5Part2Solution solution = new Day5Part2Solution();
        assertSolutionIsCorrect(solution, 12);
    }

}