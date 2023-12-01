package com.cpt.adventofcode.solution.year2023.day1;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 1 Part 1")
class Day1Part1Solution2023Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 142")
    void givenTestInput_ShouldReturn142() {
        Day1Part1Solution2023 solution = new Day1Part1Solution2023();
        assertSolutionIsCorrect(solution, 142);
    }

}