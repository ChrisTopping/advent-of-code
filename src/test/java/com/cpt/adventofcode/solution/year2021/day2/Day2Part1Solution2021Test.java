package com.cpt.adventofcode.solution.year2021.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 150")
    void givenTestInput_ShouldReturn150() {
        Day2Part1Solution2021 solution = new Day2Part1Solution2021();
        assertSolutionIsCorrect(solution, 150);
    }

}