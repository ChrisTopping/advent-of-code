package com.cpt.adventofcode.solution.year2023.day4;

import com.cpt.adventofcode.helpers.Strings;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Card {

    private static final String parsePattern = "Card\\s+(?<index>\\d+)\\s*:\\s*(?<winningNumbers>.*)\\s*\\|\\s*(?<yourNumbers>.*)\\s*";

    @Getter
    private final int index;
    private final List<Integer> winningNumbers;
    private final List<Integer> yourNumbers;

    private List<Integer> matchingNumbers = new ArrayList<>();

    public Card(String input) {
        Strings.ItemMatcher itemMatcher = new Strings.ItemMatcher(parsePattern, Map.of(
                "index", Strings.Type.INTEGER,
                "winningNumbers", Strings.Type.STRING,
                "yourNumbers", Strings.Type.STRING)
        );
        Map<String, Object> results = Strings.parse(input, itemMatcher);

        index = (int) results.get("index");
        winningNumbers = Strings.splitAndCast((String) results.get("winningNumbers"), "\\s+", Strings.Type.INTEGER);
        yourNumbers = Strings.splitAndCast((String) results.get("yourNumbers"), "\\s+", Strings.Type.INTEGER);
    }

    public void scratch() {
        matchingNumbers = yourNumbers.stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList());
    }

    public int getScore() {
        return (int) Math.pow(2, matchingNumbers.size() - 1);
    }

    public int getMatchesCount() {
        return matchingNumbers.size();
    }
}
