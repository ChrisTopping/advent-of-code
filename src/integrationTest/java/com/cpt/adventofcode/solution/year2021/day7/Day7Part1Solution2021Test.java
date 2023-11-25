package com.cpt.adventofcode.solution.year2021.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day7Part1Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 345197")
    void givenTestInput_ShouldReturn345197() {
        Day7Part1Solution2021 solution = new Day7Part1Solution2021();
        assertSolutionIsCorrect(solution, 345197);
    }

}