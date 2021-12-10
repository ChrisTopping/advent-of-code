package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 537")
    void givenTestInput_ShouldReturn537() {
        Day9Part1Solution solution = new Day9Part1Solution();
        assertSolutionIsCorrect(solution, 537);
    }

}