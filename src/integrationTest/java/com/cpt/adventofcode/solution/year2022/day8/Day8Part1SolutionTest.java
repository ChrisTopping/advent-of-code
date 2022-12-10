package com.cpt.adventofcode.solution.year2022.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 8 Part 1")
class Day8Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 21")
    void givenTestInput_ShouldReturn21() {
        Day8Part1Solution solution = new Day8Part1Solution();
        assertSolutionIsCorrect(solution, 21);
    }

}