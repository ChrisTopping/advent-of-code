package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day7Part1SolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1084134")
    void givenTestInput_ShouldReturn1084134() {
        Day7Part1Solution solution = new Day7Part1Solution();
        assertSolutionIsCorrect(solution, 1084134L);
    }

}