package com.cpt.adventofcode.solution.year2022.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 1")
class Day3Part1SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 157")
    void givenTestInput_ShouldReturn157() {
        Day3Part1Solution solution = new Day3Part1Solution();
        assertSolutionIsCorrect(solution, 157);
    }

}