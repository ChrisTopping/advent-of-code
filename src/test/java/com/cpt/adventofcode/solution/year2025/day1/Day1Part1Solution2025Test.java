package com.cpt.adventofcode.solution.year2025.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 1")
class Day1Part1Solution2025Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 3")
    void givenTestInput_ShouldReturn3() {
        Day1Part1Solution2025 solution = new Day1Part1Solution2025();
        assertSolutionIsCorrect(solution, 3);
    }

}