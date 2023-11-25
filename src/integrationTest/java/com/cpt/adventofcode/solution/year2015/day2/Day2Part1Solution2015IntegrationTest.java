package com.cpt.adventofcode.solution.year2015.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1606483")
    void givenTestInput_ShouldReturn43() {
        Day2Part1Solution2015 solution = new Day2Part1Solution2015();
        assertSolutionIsCorrect(solution, 1606483);
    }

}