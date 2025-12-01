package com.cpt.adventofcode.solution.year2015.day12;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 12 Part 1")
class Day12Part1Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 191164")
    void givenTestInput_ShouldReturn191164() {
        Day12Part1Solution2015 solution = new Day12Part1Solution2015();
        assertSolutionIsCorrect(solution, 191164);
    }

}