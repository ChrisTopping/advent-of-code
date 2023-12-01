package com.cpt.adventofcode.solution.year2021.day2;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 2 Part 2")
class Day2Part2Solution2021Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 1251263225")
    void givenTestInput_ShouldReturn1251263225() {
        Day2Part2Solution2021 solution = new Day2Part2Solution2021();
        assertSolutionIsCorrect(solution, 1251263225);
    }


}