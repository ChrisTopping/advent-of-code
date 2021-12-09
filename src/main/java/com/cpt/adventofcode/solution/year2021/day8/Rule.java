package com.cpt.adventofcode.solution.year2021.day8;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class Rule {

    private final BiPredicate<String, Input> predicate;
    private final BiConsumer<String, Input> consumer;

    public Rule(int digit, int length) {
        predicate = (s, input) -> input.length(s, length);
        consumer = (s, input) -> input.set(digit, s);
    }

    public Rule(int digit, int length, int intersectsWith, int intersections) {
        this.predicate = (s, input) -> input.length(s, length) && input.intersects(s, intersectsWith, intersections);
        this.consumer = (s, input) -> input.set(digit, s);
    }

    public void check(String chars, Input input) {
        if (predicate.test(chars, input)) {
            consumer.accept(chars, input);
        }
    }

}
