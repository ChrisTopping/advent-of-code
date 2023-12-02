package com.cpt.adventofcode.solution.year2023.day2;

import com.cpt.adventofcode.helpers.Strings;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
class GameSet {
    private int blue;
    private int green;
    private int red;

    public GameSet(String input) {
        Pattern pattern = Pattern.compile("(?<count>\\d+) .*");

        Strings.splitAndCast(input, ", ", Strings.Type.STRING)
                .forEach(s -> {
                    Matcher matcher = pattern.matcher((String) s);
                    matcher.find();

                    if (((String) s).contains("red")) {
                        red = Integer.parseInt(matcher.group("count"));
                    } else if (((String) s).contains("blue")) {
                        blue = Integer.parseInt(matcher.group("count"));
                    } else if (((String) s).contains("green")) {
                        green = Integer.parseInt(matcher.group("count"));
                    }
                });
    }

    public boolean isLegal(int maxBlue, int maxGreen, int maxRed) {
        return blue <= maxBlue && green <= maxGreen && red <= maxRed;
    }
}
