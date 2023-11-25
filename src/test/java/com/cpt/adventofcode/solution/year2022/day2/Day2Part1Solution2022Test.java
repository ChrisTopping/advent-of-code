package com.cpt.adventofcode.solution.year2022.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 15")
    void givenTestInput_ShouldReturn15() {
        Day2Part1Solution2022 solution = new Day2Part1Solution2022();
        assertSolutionIsCorrect(solution, 15);
    }

}