package com.cpt.adventofcode.solution.year2015.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 1")
class Day4Part1Solution2015IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1048970")
    void givenTestInput_ShouldReturn1048970() {
        Day4Part1Solution2015 solution = new Day4Part1Solution2015();
        assertSolutionIsCorrect(solution, 117946L);
    }

}