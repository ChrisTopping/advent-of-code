package com.cpt.adventofcode.solution.year2025.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 1, part = 1,
        description = "Secret Entrance",
        link = "https://adventofcode.com/2025/day/1"
)
public class Day1Part1Solution2025 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        AtomicInteger position = new AtomicInteger(50);
        AtomicInteger zeroCount = new AtomicInteger();
        inputStream.forEach(s -> {
            boolean isPositive = s.substring(0, 1).equalsIgnoreCase("R");
            int distance = Integer.parseInt(s.substring(1));
            position.set((position.get() + (isPositive ? +distance : -distance)) % 100);
            if (position.get() == 0) {
                zeroCount.getAndIncrement();
            }
        });

        return zeroCount.get();
    }

}