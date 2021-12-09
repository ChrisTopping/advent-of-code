package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.BaseTest;
import com.cpt.adventofcode.solution.year2021.day7.Day7Part1Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day8Part1SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 272")
    void givenTestInput_ShouldReturn272() {
        Day8Part1Solution solution = new Day8Part1Solution();
        assertSolutionIsCorrect(solution, 272L);
    }

}