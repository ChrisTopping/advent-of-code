package com.cpt.adventofcode.solution.year2021.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 1")
class Day1Part1Solution2021Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 7")
    void givenTestInput_ShouldReturn7() {
        Day1Part1Solution2021 solution = new Day1Part1Solution2021();
        assertSolutionIsCorrect(solution, 7L);
    }

}