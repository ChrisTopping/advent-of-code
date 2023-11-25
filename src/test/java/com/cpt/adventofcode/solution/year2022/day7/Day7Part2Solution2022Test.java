package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Day 7 Part 2")
class Day7Part2Solution2022Test extends BaseTest<Long> {

    @Test
    @DisplayName("Given test input: should return 24933642")
    void givenTestInput_ShouldReturn24933642() {
        Day7Part2Solution2022 solution = new Day7Part2Solution2022();
        assertSolutionIsCorrect(solution, 24933642L);
    }

}