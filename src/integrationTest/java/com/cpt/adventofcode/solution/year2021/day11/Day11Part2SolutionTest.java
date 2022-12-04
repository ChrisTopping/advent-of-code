package com.cpt.adventofcode.solution.year2021.day11;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 11 Part 2")
class Day11Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 337")
    void givenTestInput_ShouldReturn195() {
        Day11Part2Solution solution = new Day11Part2Solution();
        assertSolutionIsCorrect(solution, 337);
    }

}