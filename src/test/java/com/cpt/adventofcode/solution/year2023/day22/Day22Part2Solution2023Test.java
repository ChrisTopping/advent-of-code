package com.cpt.adventofcode.solution.year2023.day22;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 22 Part 2")
class Day22Part2Solution2023Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day22Part2Solution2023 solution = new Day22Part2Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}