package com.cpt.adventofcode.solution.year2021.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 2")
class Day1Part2Solution2021Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1429")
    void givenTestInput_ShouldReturn1429L() {
        Day1Part2Solution2021 solution = new Day1Part2Solution2021();
        assertSolutionIsCorrect(solution, 1429L);
    }

}