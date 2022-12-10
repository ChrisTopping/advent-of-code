package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day7Part2SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 6183184")
    void givenTestInput_ShouldReturn6183184() {
        Day7Part2Solution solution = new Day7Part2Solution();
        assertSolutionIsCorrect(solution, 6183184L);
    }

}