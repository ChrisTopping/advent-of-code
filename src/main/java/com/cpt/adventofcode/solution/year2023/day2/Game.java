package com.cpt.adventofcode.solution.year2023.day2;

import com.cpt.adventofcode.helpers.Strings;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class Game {
    private int id;
    private Set<GameSet> gameSets;

    public int getId() {
        return id;
    }

    public Game(String input) {
        String pattern = "Game (?<id>\\d+):(?<gameSets>.*)";
        Map<String, Strings.Type> typeMap = Map.of("id", Strings.Type.INTEGER, "gameSets", Strings.Type.STRING);

        Strings.ItemMatcher itemMatcher = new Strings.ItemMatcher(pattern, typeMap);
        Map<String, Object> results = Strings.parse(input, itemMatcher);

        this.id = (int) results.get("id");

        List<String> gameSetStrings = Strings.splitAndCast((String) results.get("gameSets"), ";", Strings.Type.STRING);
        gameSets = gameSetStrings.stream().map(GameSet::new).collect(Collectors.toSet());
    }

    public boolean isLegal(int maxBlue, int maxGreen, int maxRed) {
        return gameSets.stream()
                .allMatch(gameSet -> gameSet.isLegal(maxBlue, maxGreen, maxRed));
    }

    public int calculatePower() {
        int maxBlue = gameSets.stream()
                .mapToInt(GameSet::getBlue)
                .max()
                .orElse(0);

        int maxGreen = gameSets.stream()
                .mapToInt(GameSet::getGreen)
                .max()
                .orElse(0);

        int maxRed = gameSets.stream()
                .mapToInt(GameSet::getRed)
                .max()
                .orElse(0);

        return maxBlue * maxGreen * maxRed;
    }
}
