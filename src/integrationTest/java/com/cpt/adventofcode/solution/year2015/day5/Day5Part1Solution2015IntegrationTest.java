package com.cpt.adventofcode.solution.year2015.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 1")
class Day5Part1Solution2015IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 2")
    void givenTestInput_ShouldReturn2() {
        Day5Part1Solution2015 solution = new Day5Part1Solution2015();
        assertSolutionIsCorrect(solution, 258L);
    }

}