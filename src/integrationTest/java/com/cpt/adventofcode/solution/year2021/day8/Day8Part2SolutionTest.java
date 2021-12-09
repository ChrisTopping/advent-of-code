package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.BaseTest;
import com.cpt.adventofcode.solution.year2021.day7.Day7Part2Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day8Part2SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1007675")
    void givenTestInput_ShouldReturn1007675() {
        Day8Part2Solution solution = new Day8Part2Solution();
        assertSolutionIsCorrect(solution, 1007675L);
    }

}