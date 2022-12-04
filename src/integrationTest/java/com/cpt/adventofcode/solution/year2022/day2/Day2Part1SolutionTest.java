package com.cpt.adventofcode.solution.year2022.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 9759")
    void givenTestInput_ShouldReturn15() {
        Day2Part1Solution solution = new Day2Part1Solution();
        assertSolutionIsCorrect(solution, 9759);
    }

}