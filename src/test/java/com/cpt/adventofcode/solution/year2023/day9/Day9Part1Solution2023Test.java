package com.cpt.adventofcode.solution.year2023.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part1Solution2023Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 114")
    void givenTestInput_ShouldReturn0() {
        Day9Part1Solution2023 solution = new Day9Part1Solution2023();
        assertSolutionIsCorrect(solution, 114L);
    }

}