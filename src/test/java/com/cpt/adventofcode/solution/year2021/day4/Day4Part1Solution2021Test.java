package com.cpt.adventofcode.solution.year2021.day4;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 4 Part 1")
class Day4Part1Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 4512")
    void givenTestInput_ShouldReturn4512() {
        Day4Part1Solution2021 solution = new Day4Part1Solution2021();
        assertSolutionIsCorrect(solution, 4512);
    }

}