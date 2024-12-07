package com.cpt.adventofcode.solution.year2024.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day7Part1Solution2024Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day7Part1Solution2024 solution = new Day7Part1Solution2024();
        assertSolutionIsCorrect(solution, 0);
    }

}