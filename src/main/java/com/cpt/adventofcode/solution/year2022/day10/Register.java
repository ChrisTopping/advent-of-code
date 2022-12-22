package com.cpt.adventofcode.solution.year2022.day10;

import lombok.AllArgsConstructor;

import java.util.Stack;
import java.util.stream.Stream;

@AllArgsConstructor
public class Register {
    Stack<Integer> record;

    public static Register initialise(Stream<String> input) {
        Stack<Integer> record = new Stack<>();
        record.push(1);
        Register register = new Register(record);

        input.forEach(s -> {
            if (s.contains("noop")) {
                register.noop();
            } else {
                register.add(Integer.parseInt(s.substring(5)));
            }
        });
        return register;
    }

    public void add(int value) {
        noop();
        record.push(record.peek() + value);
    }

    public void noop() {
        record.push(record.peek());
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
