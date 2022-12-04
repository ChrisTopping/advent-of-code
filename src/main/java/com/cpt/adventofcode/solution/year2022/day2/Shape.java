package com.cpt.adventofcode.solution.year2022.day2;

import java.util.Arrays;

public enum Shape {
    ROCK("A","X",1),

    PAPER("B","Y",2),

    SCISSORS("C","Z",3);

    private String opponentCode;
    private String playerCode;
    private int score;
    private Shape beats;

    static {
        ROCK.beats = SCISSORS;
        PAPER.beats = ROCK;
        SCISSORS.beats = PAPER;
    }

    Shape(String opponentCode, String playerCode, int score) {
        this.opponentCode = opponentCode;
        this.playerCode = playerCode;
        this.score = score;
    }

    public static Shape fromOpponentCode(String opponentCode) {
        return Arrays.stream(values()).filter(shape -> shape.opponentCode.equals(opponentCode)).findFirst().orElse(null);
    }

    public static Shape fromPlayerCode(String playerCode) {
        return Arrays.stream(values()).filter(shape -> shape.playerCode.equals(playerCode)).findFirst().orElse(null);
    }

    boolean beats(Shape other) {
        return this.beats.equals(other);
    }

    public int getScore() {
        return score;
    }

    public Shape getBeats() {
        return beats;
    }

    public Shape getIsBeatenBy() {
        return beats.beats;
    }
}
