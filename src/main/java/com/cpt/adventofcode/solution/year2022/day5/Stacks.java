package com.cpt.adventofcode.solution.year2022.day5;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Stacks {
    private final List<Stack<String>> stacks;

    public static Stacks fromStrings(List<String> stackStrings) {
        ArrayList<Stack<String>> stacks = new ArrayList<>();
        for (int column = 1; column < stackStrings.get(stackStrings.size() - 1).length(); column += 4) {
            stacks.add(createStack(stackStrings, column));
        }

        return new Stacks(stacks);
    }

    private static Stack<String> createStack(List<String> stackStrings, int column) {
        Stack<String> stack = new Stack<>();
        for (String stackString : stackStrings) {
            String crate = String.valueOf(stackString.charAt(column));
            if (!crate.isBlank()) {
                stack.push(crate);
            }
        }
        return stack;
    }

    public Stack<String> get(int column) {
        return stacks.get(column);
    }

    public String getTopCrates() {
        return stacks.stream()
                .map(Stack::pop)
                .collect(Collectors.joining());
    }
}
