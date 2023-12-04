package com.cpt.adventofcode.solution.year2023.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 1")
class Day4Part1Solution2023Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day4Part1Solution2023 solution = new Day4Part1Solution2023();
        assertSolutionIsCorrect(solution, 13);
    }

}