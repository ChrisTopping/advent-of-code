package com.cpt.adventofcode.solution.year2025.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 2")
class Day2Part2Solution2025BruteForceTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 4174379265")
    void givenTestInput_ShouldReturn4174379265() {
        Day2Part2Solution2025BruteForce solution = new Day2Part2Solution2025BruteForce();
        assertSolutionIsCorrect(solution, 4174379265L);
    }

}