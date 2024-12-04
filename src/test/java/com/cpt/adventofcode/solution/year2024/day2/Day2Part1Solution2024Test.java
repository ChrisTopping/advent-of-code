package com.cpt.adventofcode.solution.year2024.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1Solution2024Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 2")
    void givenTestInput_ShouldReturn0() {
        Day2Part1Solution2024 solution = new Day2Part1Solution2024();
        assertSolutionIsCorrect(solution, 2);
    }

}