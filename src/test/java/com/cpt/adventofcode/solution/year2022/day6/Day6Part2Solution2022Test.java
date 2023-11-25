package com.cpt.adventofcode.solution.year2022.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 2")
class Day6Part2Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 19")
    void givenTestInput_ShouldReturn19() {
        Day6Part2Solution2022 solution = new Day6Part2Solution2022();
        assertSolutionIsCorrect(solution, 19);
    }

}