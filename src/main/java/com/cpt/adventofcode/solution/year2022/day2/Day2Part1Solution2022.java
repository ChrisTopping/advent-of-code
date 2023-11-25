package com.cpt.adventofcode.solution.year2022.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.Arrays;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 2, part = 1,
        description = "Rock Paper Scissors",
        link = "https://adventofcode.com/2022/day/2",
        tags = ""
)
public class Day2Part1Solution2022 implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        return inputStream
                .map(Pair::new)
                .map(Pair::getTotalScore)
                .mapToInt(value -> value)
                .sum();
    }

    static class Pair {
        Shape opponent;
        Shape player;

        Pair(String pairString) {
            String[] shapes = pairString.split("\\s+");
            this.opponent = Shape.fromOpponentCode(shapes[0]);
            this.player = Shape.fromPlayerCode(shapes[1]);
        }

        int getTotalScore() {
            int i = getShapeScore() + getOutcomeScore();
            return i;
        }

        private int getShapeScore() {
            return player.getScore();
        }

        private int getOutcomeScore() {
            int score = 0;
            if (player.beats(opponent)) {
                score = 6;
            } else if (player.equals(opponent)) {
                score = 3;
            }

            return score;
        }
    }

}