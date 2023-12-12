package com.cpt.adventofcode.solution.year2023.day12;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 12 Part 1")
class Day12Part1Solution2023Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day12Part1Solution2023 solution = new Day12Part1Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}