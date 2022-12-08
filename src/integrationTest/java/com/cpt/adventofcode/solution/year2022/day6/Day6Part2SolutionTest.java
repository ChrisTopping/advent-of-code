package com.cpt.adventofcode.solution.year2022.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 2")
class Day6Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 2178")
    void givenTestInput_ShouldReturn2178() {
        Day6Part2Solution solution = new Day6Part2Solution();
        assertSolutionIsCorrect(solution, 2178);
    }

}