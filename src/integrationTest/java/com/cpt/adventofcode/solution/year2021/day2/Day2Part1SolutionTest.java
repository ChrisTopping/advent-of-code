package com.cpt.adventofcode.solution.year2021.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1580000")
    void givenTestInput_ShouldReturn1580000() {
        Day2Part1Solution solution = new Day2Part1Solution();
        assertSolutionIsCorrect(solution, 1580000);
    }

}