package com.cpt.adventofcode.solution.year2015.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 1")
class Day1Part1Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 74")
    void givenTestInput_ShouldReturnMinus3() {
        Day1Part1Solution2015 solution = new Day1Part1Solution2015();
        assertSolutionIsCorrect(solution, 74);
    }

}