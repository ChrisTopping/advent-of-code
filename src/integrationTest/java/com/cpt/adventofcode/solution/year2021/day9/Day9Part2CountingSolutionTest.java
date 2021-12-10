package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 2 - Counting")
class Day9Part2CountingSolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1142757")
    void givenTestInput_ShouldReturn1142757() {
        Day9Part2CountingSolution solution = new Day9Part2CountingSolution();
        assertSolutionIsCorrect(solution, 1142757);
    }

}