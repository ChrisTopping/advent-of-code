package com.cpt.adventofcode.solution.year2022.day9;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 9 Part 1")
class Day9Part1Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 13")
    void givenTestInput_ShouldReturn13() {
        Day9Part1Solution2022 solution = new Day9Part1Solution2022();
        assertSolutionIsCorrect(solution, 13);
    }

}