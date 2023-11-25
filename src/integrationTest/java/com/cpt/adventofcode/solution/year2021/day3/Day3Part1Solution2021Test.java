package com.cpt.adventofcode.solution.year2021.day3;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 3 Part 1")
class Day3Part1Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 3374136")
    void givenTestInput_ShouldReturn3374136() {
        Day3Part1Solution2021 solution = new Day3Part1Solution2021();
        assertSolutionIsCorrect(solution, 3374136);
    }

}