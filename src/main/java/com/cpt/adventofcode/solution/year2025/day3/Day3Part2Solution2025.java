package com.cpt.adventofcode.solution.year2025.day3;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2025, day = 3, part = 2,
        description = "Lobby",
        link = "https://adventofcode.com/2025/day/3#part2"
)
public class Day3Part2Solution2025 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        return inputStream.mapToLong(s -> {
            List<Integer> bank = s.chars().map(c -> c - '0').boxed().toList();


            int[] maximumJoltageAllocation = new int[12];

            for (int bankPosition = 0; bankPosition < bank.size(); bankPosition++) {
                Integer currentBattery = bank.get(bankPosition);
                for (int allocation = 0; allocation < 12; allocation++) {
                    if (bankPosition < bank.size() - (11 - allocation) && currentBattery > maximumJoltageAllocation[allocation]) {
                        maximumJoltageAllocation[allocation] = currentBattery;
                        for (int invalidatedAllocation = allocation + 1; invalidatedAllocation < 12; invalidatedAllocation++) {
                            maximumJoltageAllocation[invalidatedAllocation] = 0;
                        }
                        break;
                    }
                }
            }

            String maximumJoltageAllocationString = Arrays.stream(maximumJoltageAllocation)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(""));

            return Long.parseLong(maximumJoltageAllocationString);
        }).sum();
    }

}