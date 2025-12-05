package com.cpt.adventofcode.solution.year2025.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.List;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 3, part = 1,
        description = "Lobby",
        link = "https://adventofcode.com/2025/day/3"
)
public class Day3Part1Solution2025 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream.mapToInt(s -> {
            List<Integer> bank = s.chars().map(c -> c - '0').boxed().toList();

            int firstBattery = 0;
            int secondBattery = 0;

            for (int bankPosition = 0; bankPosition < bank.size(); bankPosition++) {
                Integer currentBattery = bank.get(bankPosition);
                if (currentBattery > firstBattery && bankPosition < bank.size() - 1) {
                    firstBattery = currentBattery;
                    secondBattery = 0;
                } else if (currentBattery > secondBattery) {
                    secondBattery = currentBattery;
                }
            }
            return Integer.parseInt("%d%d".formatted(firstBattery, secondBattery));
        }).sum();
    }

}