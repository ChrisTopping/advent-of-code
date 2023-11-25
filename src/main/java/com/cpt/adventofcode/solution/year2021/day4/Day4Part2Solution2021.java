package com.cpt.adventofcode.solution.year2021.day4;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 4, part = 2,
        description = "Giant Squid",
        link = "https://adventofcode.com/2021/day/4"
)
public class Day4Part2Solution2021 extends Day4Solution {

    @Override
    public Integer solve(Stream<String> inputStream) {
        List<String> inputStrings = inputStream.collect(Collectors.toList());

        int[] numbers = initialiseNumbers(inputStrings);
        List<Card> cards = initialiseCards(inputStrings);

        for (int number : numbers) {
            List<Card> nonWinningCards = cards.stream().peek(card -> card.callNumber(number))
                    .filter(card -> !card.isWinning())
                    .collect(Collectors.toList());

            if (nonWinningCards.size() == 0) {
                Card losingCard = cards.get(0);
                losingCard.callNumber(number);
                return losingCard.sumUncalledNumbers() * number;
            }

            cards = nonWinningCards;
        }

        throw new RuntimeException("Could not find winning card");
    }

}
