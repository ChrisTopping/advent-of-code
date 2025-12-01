package com.cpt.adventofcode.solution.year2015.day14;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 14 Part 1")
class Day14Part1Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 2660")
    void givenTestInput_ShouldReturn2660() {
        Day14Part1Solution2015 solution = new Day14Part1Solution2015();
        assertSolutionIsCorrect(solution, 2660);
    }

}