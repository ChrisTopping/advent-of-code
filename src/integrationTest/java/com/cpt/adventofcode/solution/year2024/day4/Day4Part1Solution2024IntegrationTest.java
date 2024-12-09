package com.cpt.adventofcode.solution.year2024.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 1")
class Day4Part1Solution2024IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 2591")
    void givenTestInput_ShouldReturn0() {
        Day4Part1Solution2024 solution = new Day4Part1Solution2024();
        assertSolutionIsCorrect(solution, 2591);
    }

}