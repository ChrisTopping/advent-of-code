package com.cpt.adventofcode.solution.year2021.day11;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 11 Part 1")
class Day11Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1656")
    void givenTestInput_ShouldReturn1656() {
        Day11Part1Solution solution = new Day11Part1Solution();
        assertSolutionIsCorrect(solution, 1656);
    }

}