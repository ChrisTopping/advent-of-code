package com.cpt.adventofcode.solution.year2015.day13;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Arrangement {
    private final Map<String, Guest> guests = new HashMap<>();

    public Guest putIfAbsent(String name) {
        return guests.computeIfAbsent(name, Guest::new);
    }

    public Collection<Guest> getGuests() {
        return guests.values();
    }
}
