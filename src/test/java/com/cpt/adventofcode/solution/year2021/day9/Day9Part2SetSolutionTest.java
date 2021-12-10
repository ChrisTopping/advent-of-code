package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part2SetSolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1134")
    void givenTestInput_ShouldReturn1134() {
        Day9Part2SetSolution solution = new Day9Part2SetSolution();
        assertSolutionIsCorrect(solution, 1134);
    }

}