package com.cpt.adventofcode.solution.year2025.day1;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 1, part = 2,
        description = "Secret Entrance",
        link = "https://adventofcode.com/2025/day/1#part2"
)
public class Day1Part2Solution2025 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        AtomicInteger position = new AtomicInteger(50);
        AtomicInteger zeroCount = new AtomicInteger();
        inputStream.forEach(s -> {
            int sign = s.substring(0, 1).equalsIgnoreCase("R") ? 1 : -1;
            int distance = Integer.parseInt(s.substring(1));

            int current = position.get();

            int distanceToBoundary = (sign > 0) ? (100 - current) : current;
            if (distanceToBoundary == 0) {
                distanceToBoundary = 100;
            }

            if (distance >= distanceToBoundary) {
                zeroCount.addAndGet(1 + (distance - distanceToBoundary) / 100);
            }

            int nextPosition = (current + sign * distance) % 100;
            if (nextPosition < 0) {
                nextPosition += 100;
            }

            position.set(nextPosition);
        });

        return zeroCount.get();
    }

}
