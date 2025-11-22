package com.cpt.adventofcode.solution.year2015.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day7Part1Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return ")
    void givenTestInput_ShouldReturn() {
        Day7Part1Solution2015 solution = new Day7Part1Solution2015();
        assertSolutionIsCorrect(solution, 0);
    }

}