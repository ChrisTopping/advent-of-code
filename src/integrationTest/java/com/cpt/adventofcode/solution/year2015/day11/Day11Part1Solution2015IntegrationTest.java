package com.cpt.adventofcode.solution.year2015.day11;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 11 Part 1")
class Day11Part1Solution2015IntegrationTest extends BaseTest<String> {

    @Test
    @DisplayName("Given test input: should return hxbxxyzz")
    void givenTestInput_ShouldReturn() {
        Day11Part1Solution2015 solution = new Day11Part1Solution2015();
        assertSolutionIsCorrect(solution, "hxbxxyzz");
    }

}