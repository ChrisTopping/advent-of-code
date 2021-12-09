package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day8Part1SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 26")
    void givenTestInput_ShouldReturn26() {
        Day8Part1Solution solution = new Day8Part1Solution();
        assertSolutionIsCorrect(solution, 26L);
    }

}