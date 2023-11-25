package com.cpt.adventofcode.solution.year2015.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 1")
class Day3Part1Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 2081")
    void givenTestInput_ShouldReturn4() {
        Day3Part1Solution2015 solution = new Day3Part1Solution2015();
        assertSolutionIsCorrect(solution, 2081);
    }

}