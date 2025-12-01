package com.cpt.adventofcode.solution.year2015.day13;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 13 Part 2")
class Day13Part2Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 601")
    void givenTestInput_ShouldReturn601() {
        Day13Part2Solution2015 solution = new Day13Part2Solution2015();
        assertSolutionIsCorrect(solution, 601);
    }

}