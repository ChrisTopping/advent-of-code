package com.cpt.adventofcode.solution.year2015.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 2")
class Day2Part2Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 14")
    void givenTestInput_ShouldReturn14() {
        Day2Part2Solution2015 solution = new Day2Part2Solution2015();
        assertSolutionIsCorrect(solution, 14);
    }

}