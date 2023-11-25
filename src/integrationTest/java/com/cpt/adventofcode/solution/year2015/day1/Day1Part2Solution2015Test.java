package com.cpt.adventofcode.solution.year2015.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 2")
class Day1Part2Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 5")
    void givenTestInput_ShouldReturn5() {
        Day1Part2Solution2015 solution = new Day1Part2Solution2015();
        assertSolutionIsCorrect(solution, 1);
    }

}