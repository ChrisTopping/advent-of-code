package com.cpt.adventofcode.solution.year2015.day12;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 12 Part 2")
class Day12Part2Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 87842")
    void givenTestInput_ShouldReturn87842() {
        Day12Part2Solution2015 solution = new Day12Part2Solution2015();
        assertSolutionIsCorrect(solution, 87842);
    }

}