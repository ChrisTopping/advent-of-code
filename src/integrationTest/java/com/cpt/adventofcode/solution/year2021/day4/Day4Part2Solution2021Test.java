package com.cpt.adventofcode.solution.year2021.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 2")
class Day4Part2Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 23042")
    void givenTestInput_ShouldReturn23042() {
        Day4Part2Solution2021 solution = new Day4Part2Solution2021();
        assertSolutionIsCorrect(solution, 23042);
    }

}