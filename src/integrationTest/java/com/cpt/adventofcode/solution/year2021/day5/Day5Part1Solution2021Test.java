package com.cpt.adventofcode.solution.year2021.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 1")
class Day5Part1Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 6189")
    void givenTestInput_ShouldReturn6189() {
        Day5Part1Solution2021 solution = new Day5Part1Solution2021();
        assertSolutionIsCorrect(solution, 6189);
    }

}