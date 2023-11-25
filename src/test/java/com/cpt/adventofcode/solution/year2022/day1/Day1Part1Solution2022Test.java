package com.cpt.adventofcode.solution.year2022.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 1")
class Day1Part1Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 24000")
    void givenTestInput_ShouldReturn24000() {
        Day1Part1Solution2022 solution = new Day1Part1Solution2022();
        assertSolutionIsCorrect(solution, 24000);
    }

}