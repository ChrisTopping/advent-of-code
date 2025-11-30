package com.cpt.adventofcode.solution.year2015.day9;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class World {
    private final Map<String, City> cities = new HashMap<>();

    public City putIfAbsent(String name) {
        return cities.computeIfAbsent(name, City::new);
    }

    public Collection<City> getCites() {
        return cities.values();
    }

    public static World createWorld() {
        return new World();
    }
}
