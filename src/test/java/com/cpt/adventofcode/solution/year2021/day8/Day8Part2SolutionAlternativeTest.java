package com.cpt.adventofcode.solution.year2021.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day8Part2SolutionAlternativeTest extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 61229")
    void givenTestInput_ShouldReturn61229() {
        Day8Part2SolutionAlternative solution = new Day8Part2SolutionAlternative();
        assertSolutionIsCorrect(solution, 61229L);
    }

}