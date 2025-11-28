package com.cpt.adventofcode.solution.year2015.day8;

import com.cpt.adventofcode.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.cpt.adventofcode.solution.year2015.day8.Day8Part1Solution2015.escape;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 8 Part 1")
class Day8Part1Solution2015Test extends BaseTest<Integer> {

    @Test
    @DisplayName("Given test input: should return 0")
    void givenTestInput_ShouldReturn0() {
        Day8Part1Solution2015 solution = new Day8Part1Solution2015();
        assertSolutionIsCorrect(solution, 12);
    }

    @Nested
    @DisplayName("escape()")
    class Escape {

        @Test
        @DisplayName("Should strip double quotes")
        void shouldStripDoubleQuotes() {
            assertEscaped("\"\"","");
        }

        @Test
        @DisplayName("Should strip double quotes but keep contents")
        void shouldStripDoubleQuotesAndKeepContents() {
            assertEscaped("\"abc\"","abc");
        }

        @Test
        @DisplayName("Should keep escaped quotes")
        void shouldKeepEscapedQuotesAndKeepContents() {
            assertEscaped("\"aaa\\\"aaa\"", "aaa\"aaa");
        }

        @Test
        @DisplayName("Should replace hex with octothorpe")
        void shouldReplaceHexWithOctothorpe() {
            assertEscaped("\"\\x27\"", "#");
        }

        private void assertEscaped(String input, String escaped) {
            assertThat(escape(input)).isEqualTo(escaped);
        }

    }

}