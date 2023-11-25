package com.cpt.adventofcode.solution.year2015.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 2")
class Day4Part2Solution2015IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return ")
    void givenTestInput_ShouldReturn() {
        Day4Part2Solution2015 solution = new Day4Part2Solution2015();
        assertSolutionIsCorrect(solution, 3938038L);
    }

}