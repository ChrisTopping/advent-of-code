package com.cpt.adventofcode.solution.year2015.day3;

import java.util.HashSet;
import java.util.Set;

public class Santa {
    private final Set<House> visited = new HashSet<>();
    private House current;

    {
        current = new House(0, 0);
        visited.add(current);
    }

    public void move(String direction) {
        current = current.next(direction);
        visited.add(current);
    }

    public Set<House> getVisited() {
        return visited;
    }
}
