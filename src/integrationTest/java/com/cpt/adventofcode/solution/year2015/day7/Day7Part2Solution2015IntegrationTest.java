package com.cpt.adventofcode.solution.year2015.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day7Part2Solution2015IntegrationTest extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 14710")
    void givenTestInput_ShouldReturn() {
        Day7Part2Solution2015 solution = new Day7Part2Solution2015();
        assertSolutionIsCorrect(solution, 14710);
    }

}