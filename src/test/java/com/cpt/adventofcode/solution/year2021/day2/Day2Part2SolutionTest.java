package com.cpt.adventofcode.solution.year2021.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 2")
class Day2Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 900")
    void givenTestInput_ShouldReturn900() {
        Day2Part2Solution solution = new Day2Part2Solution();
        assertSolutionIsCorrect(solution, 900);
    }


}