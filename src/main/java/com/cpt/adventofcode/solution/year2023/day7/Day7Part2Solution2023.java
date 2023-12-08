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

@AdventOfCodeSolution(year = 2023, day = 7, part = 2,
        description = "Camel Cards",
        link = "https://adventofcode.com/2023/day/7#part2",
        tags = "unsolved"
)
public class Day7Part2Solution2023 implements Solution<Long> {

    private static final List<Character> cards = List.of('A', 'K', 'Q', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'J');

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
        Map<Character, Integer> map = hand.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));

        // if map contains J replace all Js with the cards that would improve the hands ranking the most
        // if all Js, do not replace
        // if the hand has 5 distinct cards, do not replace
        if (map.containsKey('J') && map.size() > 1 && map.size() < 5) {
            Map.Entry<Character, Integer> bestCardsEntry = map.entrySet()
                    .stream()
                    .filter(entry -> entry.getKey() != 'J')
                    .sorted((o1, o2) -> compareCards(o1.getKey(), o2.getKey()))
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList())
                    .get(0);

            map.put(bestCardsEntry.getKey(), bestCardsEntry.getValue() + map.remove('J'));
        } else if (map.containsKey('J') && map.size() == 5) {
            map.put('A', map.remove('J'));
        }
        return map;
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
                int comparison = compareCards(hand1.charAt(card), hand2.charAt(card));
                if (comparison != 0) {
                    return comparison;
                }
            }
        }

        return 0;
    }

    private static int compareCards(char card1, char card2) {
        int firstCardRanking = cards.indexOf(card1);
        int secondCardRanking = cards.indexOf(card2);
        return firstCardRanking - secondCardRanking;
    }

}