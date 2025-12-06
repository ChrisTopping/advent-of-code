package com.cpt.adventofcode.solution.year2025.day6;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 6 Part 1")
class Day6Part1Solution2025Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 4277556")
    void givenTestInput_ShouldReturn4277556() {
        Day6Part1Solution2025 solution = new Day6Part1Solution2025();
        assertSolutionIsCorrect(solution, 4277556L);
    }

}