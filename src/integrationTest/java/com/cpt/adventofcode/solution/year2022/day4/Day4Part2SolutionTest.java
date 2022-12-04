package com.cpt.adventofcode.solution.year2022.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 2")
class Day4Part2SolutionTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 893")
    void givenTestInput_ShouldReturn4() {
        Day4Part2Solution solution = new Day4Part2Solution();
        assertSolutionIsCorrect(solution, 893);
    }

}