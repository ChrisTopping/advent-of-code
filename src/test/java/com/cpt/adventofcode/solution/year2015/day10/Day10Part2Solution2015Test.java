package com.cpt.adventofcode.solution.year2015.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 2")
class Day10Part2Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 3369156")
    void givenTestInput_ShouldReturn0() {
        Day10Part2Solution2015 solution = new Day10Part2Solution2015();
        assertSolutionIsCorrect(solution, 3369156);
    }

}