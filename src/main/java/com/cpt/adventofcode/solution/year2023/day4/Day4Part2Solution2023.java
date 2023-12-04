package com.cpt.adventofcode.solution.year2023.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 4, part = 2,
        description = "Scratchcards",
        link = "https://adventofcode.com/2023/day/4#part2",
        tags = ""
)
public class Day4Part2Solution2023 implements Solution<Integer> {

    private final Map<Integer, Integer> countMap = new HashMap<>();

    @Override
    public Integer solve(Stream<String> inputStream) {
        inputStream
                .map(Card::new)
                .peek(Card::scratch)
                .peek(card -> addCardsToCount(card.getIndex(), 1))
                .sorted(Comparator.comparing(Card::getIndex))
                .forEach(card -> addCardsBasedOnCurrentCardMatches(card.getIndex(), card.getMatchesCount()));

        return countMap.values()
                .stream()
                .mapToInt(count -> count)
                .sum();
    }

    private void addCardsBasedOnCurrentCardMatches(int index, int matches) {
        if (matches > 0) {
            Integer copiesOfCurrentCard = countMap.getOrDefault(index, 0);
            IntStream.range(index + 1, index + matches + 1)
                    .forEach(newCardIndex -> addCardsToCount(newCardIndex, copiesOfCurrentCard));
        }
    }

    private void addCardsToCount(int index, int count) {
        countMap.compute(index, (k, v) -> v == null ? count : v + count);
    }

}