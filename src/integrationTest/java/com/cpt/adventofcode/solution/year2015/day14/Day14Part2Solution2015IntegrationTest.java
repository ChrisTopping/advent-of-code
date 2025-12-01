package com.cpt.adventofcode.solution.year2015.day14;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 14 Part 2")
class Day14Part2Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1084")
    void givenTestInput_ShouldReturn1084() {
        Day14Part2Solution2015 solution = new Day14Part2Solution2015();
        assertSolutionIsCorrect(solution, 1084);
    }

}