package com.cpt.adventofcode.solution.year2022.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 1")
class Day4Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 582")
    void givenTestInput_ShouldReturn2() {
        Day4Part1Solution solution = new Day4Part1Solution();
        assertSolutionIsCorrect(solution, 582);
    }

}