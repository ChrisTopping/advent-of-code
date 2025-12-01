package com.cpt.adventofcode.solution.year2015.day13;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 13 Part 2")
class Day13Part2Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 286")
    void givenTestInput_ShouldReturn286() {
        Day13Part2Solution2015 solution = new Day13Part2Solution2015();
        assertSolutionIsCorrect(solution, 286);
    }

}