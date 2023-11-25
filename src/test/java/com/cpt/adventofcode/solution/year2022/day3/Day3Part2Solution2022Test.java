package com.cpt.adventofcode.solution.year2022.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 2")
class Day3Part2Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 70")
    void givenTestInput_ShouldReturn70() {
        Day3Part2Solution2022 solution = new Day3Part2Solution2022();
        assertSolutionIsCorrect(solution, 70);
    }

}