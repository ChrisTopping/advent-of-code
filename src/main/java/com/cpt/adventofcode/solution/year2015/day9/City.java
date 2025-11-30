package com.cpt.adventofcode.solution.year2015.day9;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@ToString(of = {"name"})
@EqualsAndHashCode(exclude = "routes")
class City {
    private final String name;
    @Getter
    private final Set<Route> routes = new HashSet<>();

    public void addRoute(City to, int distance) {
        routes.add(new Route(to, distance));
    }

    public Integer getDistanceTo(City other) {
        return routes.stream()
                .filter(route -> route.to().equals(other))
                .map(Route::distance)
                .findFirst()
                .orElse(null);
    }
}
