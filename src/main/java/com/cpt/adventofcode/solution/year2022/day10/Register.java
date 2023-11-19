package com.cpt.adventofcode.solution.year2022.day10;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

@AllArgsConstructor
public class Register {
    private final Stack<Integer> record;
    private final List<String> pixels;

    public static Register initialise(Stream<String> input) {
        Stack<Integer> record = new Stack<>();
        record.push(1);
        Register register = new Register(record, new ArrayList<>());

        input.forEach(s -> {
            if (s.contains("noop")) {
                register.noop();
            } else {
                register.add(Integer.parseInt(s.substring(5)));
            }
        });
        return register;
    }

    private void add(int value) {
        draw();
        record.push(record.peek());
        draw();
        record.push(record.peek() + value);
    }

    private void noop() {
        draw();
        record.push(record.peek());
    }

    private Integer value() {
        return record.peek();
    }

    private Integer position() {
        return Math.floorMod(pixels.size(), 40);
    }

    public void draw() {
        if (Math.abs(value() - position()) <= 1) {
            pixels.add("#");
        } else {
            pixels.add(".");
        }
    }

    public String getPixels() {
        return String.join("\n",String.join("", pixels).split("(?<=\\G.{40})"));
    }

    public long calculateSignalStrength(int initialCycle, int cycleInterval) {
        int size = record.size();
        int signalStrength = 0;
        for (int i = initialCycle - 1; i < size; i += cycleInterval) {
            int toAdd = record.elementAt(i) * (i + 1);
            signalStrength += toAdd;
        }
        return signalStrength;
    }
}
