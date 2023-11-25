package com.cpt.adventofcode.solution.year2015.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.helpers.Strings;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2015, day = 1, part = 2,
        description = "Not Quite Lisp",
        link = "https://adventofcode.com/2015/day/1",
        tags = ""
)
public class Day1Part2Solution2015 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        String join = Strings.join(inputStream);
        List<String> brackets = Strings.splitAndCast(join, "", Strings.Type.STRING);
        int level = 0;

        for (int i = 0; i < brackets.size(); i++) {
            switch (brackets.get(i)) {
                case "(" -> level++;
                case ")" -> level--;
            }
            if (level < 0) {
                return i + 1;
            }
        }
        return brackets.size();
    }

}