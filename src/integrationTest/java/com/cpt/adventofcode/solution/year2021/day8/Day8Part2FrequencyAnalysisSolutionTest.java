package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day8Part2FrequencyAnalysisSolutionTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 1007675")
    void givenTestInput_ShouldReturn1007675() {
        Day8Part2FrequencyAnalysisSolution solution = new Day8Part2FrequencyAnalysisSolution();
        assertSolutionIsCorrect(solution, 1007675L);
    }

}