package com.cpt.adventofcode.solution.year2021.day11;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 11 Part 2")
class Day11Part2Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 195")
    void givenTestInput_ShouldReturn195() {
        Day11Part2Solution2021 solution = new Day11Part2Solution2021();
        assertSolutionIsCorrect(solution, 195);
    }

}