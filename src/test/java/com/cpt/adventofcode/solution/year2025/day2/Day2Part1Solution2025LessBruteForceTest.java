package com.cpt.adventofcode.solution.year2025.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 1")
class Day2Part1Solution2025LessBruteForceTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1227775554")
    void givenTestInput_ShouldReturn1227775554() {
        Day2Part1Solution2025LessBruteForce solution = new Day2Part1Solution2025LessBruteForce();
        assertSolutionIsCorrect(solution, 1227775554L);
    }

}