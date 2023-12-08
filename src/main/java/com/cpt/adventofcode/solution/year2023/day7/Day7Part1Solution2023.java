package com.cpt.adventofcode.solution.year2023.day7;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2023, day = 7, part = 1,
        description = "Camel Cards",
        link = "https://adventofcode.com/2023/day/7",
        tags = ""
)
public class Day7Part1Solution2023 implements Solution<Long> {

    private static final List<Character> cards = List.of('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2');

    @Override
    public Long solve(Stream<String> inputStream) {
        List<String[]> list = inputStream.map(s -> s.split(" "))
                .sorted((handl1, handl2) -> compareHands(handl1[0], handl2[0]))
                .collect(Collectors.toList());

        List<String[]> reversedList = Lists.reverse(list);

        return LongStream.range(0, reversedList.size())
                .map(index -> (index + 1) * Long.parseLong(reversedList.get((int) index)[1]))
                .sum();
    }

    private static Map<Character, Integer> getCardFrequencyMap(String hand) {
        return hand.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
    }

    private static int getHandType(String hand) {
        return getCardFrequencyMap(hand).values().stream().mapToInt(value -> value * value).sum();
    }

    private static int compareHands(String hand1, String hand2) {
        int type1 = getHandType(hand1);
        int type2 = getHandType(hand2);

        if (type1 != type2) {
            return type2 - type1;
        } else {
            for (int card = 0; card < hand1.length(); card++) {
                int firstCardRanking = cards.indexOf(hand1.charAt(card));
                int secondCardRanking = cards.indexOf(hand2.charAt(card));
                if (firstCardRanking != secondCardRanking) {
                    return firstCardRanking - secondCardRanking;
                }
            }
        }

        return 0;
    }

}