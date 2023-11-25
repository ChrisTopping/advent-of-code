package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day7Part1Solution2022Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 95437")
    void givenTestInput_ShouldReturn95437() {
        Day7Part1Solution2022 solution = new Day7Part1Solution2022();
        assertSolutionIsCorrect(solution, 95437L);
    }

}