package com.cpt.adventofcode.solution.year2023.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 1")
class Day7Part1Solution2023IntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 246424613")
    void givenTestInput_ShouldReturn0() {
        Day7Part1Solution2023 solution = new Day7Part1Solution2023();
        assertSolutionIsCorrect(solution, 246424613L);
    }

}