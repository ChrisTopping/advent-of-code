package com.cpt.adventofcode.solution.year2015.day14;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 14 Part 2")
class Day14Part2Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1564")
    void givenTestInput_ShouldReturn1564() {
        Day14Part2Solution2015 solution = new Day14Part2Solution2015();
        assertSolutionIsCorrect(solution, 1564);
    }

}