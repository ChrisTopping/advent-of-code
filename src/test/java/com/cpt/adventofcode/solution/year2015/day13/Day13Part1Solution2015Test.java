package com.cpt.adventofcode.solution.year2015.day13;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 13 Part 1")
class Day13Part1Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 330")
    void givenTestInput_ShouldReturn330() {
        Day13Part1Solution2015 solution = new Day13Part1Solution2015();
        assertSolutionIsCorrect(solution, 330);
    }

}