package com.cpt.adventofcode.solution.year2021.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 2")
class Day3Part2Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 230")
    void givenTestInput_ShouldReturn230() {
        Day3Part2Solution2021 solution = new Day3Part2Solution2021();
        assertSolutionIsCorrect(solution, 230);
    }

}