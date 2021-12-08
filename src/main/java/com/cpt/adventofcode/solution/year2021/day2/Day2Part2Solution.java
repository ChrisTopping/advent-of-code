package com.cpt.adventofcode.solution.year2021.day2;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;

import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2021, day = 2, part = 2,
        description = "Dive!",
        link = "https://adventofcode.com/2021/day/2"
)
public class Day2Part2Solution implements Solution<Integer> {

    @Override
    public Integer solve(Stream<String> inputStream) {
        Position position = new Position();
        inputStream.forEach(position::step);
        return position.getProduct();
    }

    static class Position {
        private int depth;
        private int horizontal;
        private int aim;

        public void step(String step) {
            String[] stepParts = step.split(" ");
            String direction = stepParts[0].toLowerCase().strip();
            int amount = Integer.parseInt(stepParts[1]);
            step(direction, amount);
        }

        private void step(String direction, int amount) {
            switch (direction) {
                case "forward" -> {
                    horizontal += amount;
                    depth += aim * amount;
                }
                case "up" -> aim -= amount;
                case "down" -> aim += amount;
            }
        }

        public int getProduct() {
            return depth * horizontal;
        }
    }

}
