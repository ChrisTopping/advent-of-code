package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day8Part1Solution2021Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 272")
    void givenTestInput_ShouldReturn272() {
        Day8Part1Solution2021 solution = new Day8Part1Solution2021();
        assertSolutionIsCorrect(solution, 272L);
    }

}