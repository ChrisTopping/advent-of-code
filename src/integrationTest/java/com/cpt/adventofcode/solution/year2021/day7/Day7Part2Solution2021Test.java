package com.cpt.adventofcode.solution.year2021.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day7Part2Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 96361630")
    void givenTestInput_ShouldReturn96361630() {
        Day7Part2Solution2021 solution = new Day7Part2Solution2021();
        assertSolutionIsCorrect(solution, 96361630);
    }

}