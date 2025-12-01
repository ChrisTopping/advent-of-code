package com.cpt.adventofcode.solution.year2015.day13;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
class Guest {
    private final String name;
    private final Set<Pairing> pairings = new HashSet<>();

    public void addWeight(Guest guest, int weight) {
        pairings.add(new Pairing(guest, weight));
    }

    public Integer getWeight(Guest guest) {
        Integer firstWeight = pairings.stream()
                .filter(pairing -> pairing.next().name.equals(guest.name))
                .map(Pairing::weight)
                .findFirst()
                .orElse(0);

        Integer secondWeight = guest.pairings.stream()
                .filter(pairing -> pairing.next().name.equals(this.name))
                .map(Pairing::weight)
                .findFirst()
                .orElse(0);

        return firstWeight + secondWeight;
    }

}
