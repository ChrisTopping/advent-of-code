package com.cpt.adventofcode.solution.year2023.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 1")
class Day5Part1Solution2023Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day5Part1Solution2023 solution = new Day5Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}