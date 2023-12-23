package com.cpt.adventofcode.solution.year2023.day23;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 23 Part 2")
class Day23Part2Solution2023Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day23Part2Solution2023 solution = new Day23Part2Solution2023();
        assertSolutionIsCorrect(solution, 0);
    }

}