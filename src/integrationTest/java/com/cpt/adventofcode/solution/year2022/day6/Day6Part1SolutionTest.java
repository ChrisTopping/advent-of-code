package com.cpt.adventofcode.solution.year2022.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 1")
class Day6Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1578")
    void givenTestInput_ShouldReturn1578() {
        Day6Part1Solution solution = new Day6Part1Solution();
        assertSolutionIsCorrect(solution, 1578);
    }

}