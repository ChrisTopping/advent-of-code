package com.cpt.adventofcode.solution.year2022.day5;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 5 Part 1")
class Day5Part1Solution2022Test extends BaseTest<String> {

    @Test
    @DisplayName("Given test input: should return CMZ")
    void givenTestInput_ShouldReturnCMZ() {
        Day5Part1Solution2022 solution = new Day5Part1Solution2022();
        assertSolutionIsCorrect(solution, "CMZ");
    }

}