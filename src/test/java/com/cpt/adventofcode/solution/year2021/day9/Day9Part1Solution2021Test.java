package com.cpt.adventofcode.solution.year2021.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part1Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 15")
    void givenTestInput_ShouldReturn15() {
        Day9Part1Solution2021 solution = new Day9Part1Solution2021();
        assertSolutionIsCorrect(solution, 15);
    }

}