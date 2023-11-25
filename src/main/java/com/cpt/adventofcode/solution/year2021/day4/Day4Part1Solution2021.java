package com.cpt.adventofcode.solution.year2021.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 4, part = 1,
        description = "Giant Squid",
        link = "https://adventofcode.com/2021/day/4"
)
public class Day4Part1Solution2021 extends Day4Solution {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> inputStrings = inputStream.collect(Collectors.toList());

        int[] numbers = initialiseNumbers(inputStrings);
        List<Card> cards = initialiseCards(inputStrings);

        for (int number : numbers) {
            Optional<Card> winningCard = cards.stream()
                    .peek(card -> card.callNumber(number))
                    .filter(Card::isWinning)
                    .findAny();

            if (winningCard.isPresent()) {
                return winningCard.get().sumUncalledNumbers() * number;
            }
        }

        throw new RuntimeException("Could not find winning card");
    }

}
