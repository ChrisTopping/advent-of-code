package com.cpt.adventofcode.solution.year2022.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 2")
class Day9Part2Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1")
    void givenTestInput_ShouldReturn1() {
        Day9Part2Solution2022 solution = new Day9Part2Solution2022();
        assertSolutionIsCorrect(solution, 1);
    }

}