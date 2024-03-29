package com.cpt.adventofcode.solution.year2022.day10;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 10 Part 1")
class Day10Part1Solution2022Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 13140")
    void givenTestInput_ShouldReturn13140() {
        Day10Part1Solution2022 solution = new Day10Part1Solution2022();
        assertSolutionIsCorrect(solution, 13140L);
    }

}