package com.cpt.adventofcode.solution.year2025.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1Solution2025BruteForceIntegrationTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 30608905813")
    void givenTestInput_ShouldReturn30608905813() {
        Day2Part1Solution2025BruteForce solution = new Day2Part1Solution2025BruteForce();
        assertSolutionIsCorrect(solution, 30608905813L);
    }

}