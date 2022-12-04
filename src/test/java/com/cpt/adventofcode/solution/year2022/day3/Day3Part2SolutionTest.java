package com.cpt.adventofcode.solution.year2022.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 2")
class Day3Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 70")
    void givenTestInput_ShouldReturn70() {
        Day3Part2Solution solution = new Day3Part2Solution();
        assertSolutionIsCorrect(solution, 70);
    }

}