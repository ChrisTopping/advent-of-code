package com.cpt.adventofcode.solution.year2021.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 1")
class Day5Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 5")
    void givenTestInput_ShouldReturn5() {
        Day5Part1Solution solution = new Day5Part1Solution();
        assertSolutionIsCorrect(solution, 5);
    }

}