package com.cpt.adventofcode.solution.year2021.day4;

import com.cpt.adventofcode.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Day4Solution implements Solution<Integer> {

    List<Card> initialiseCards(List<String> inputStrings) {
        List<Card> cards = new ArrayList<>();

        for (int line = 2; line < inputStrings.size(); line += 6) {
            Card card = new Card(5, 5);
            for (int i = 0; i < 5; i++) {
                card.addRow(inputStrings.get(line + i), i);
            }
            cards.add(card);
        }
        return cards;
    }

    int[] initialiseNumbers(List<String> inputStrings) {
        return Arrays.stream(inputStrings.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
