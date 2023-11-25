package com.cpt.adventofcode.solution.year2022.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 1")
class Day6Part1Solution2022Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 7")
    void givenTestInput_ShouldReturn7() {
        Day6Part1Solution2022 solution = new Day6Part1Solution2022();
        assertSolutionIsCorrect(solution, 7);
    }

}