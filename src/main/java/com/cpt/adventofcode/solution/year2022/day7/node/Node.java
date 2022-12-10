package com.cpt.adventofcode.solution.year2022.day7.node;

import lombok.Getter;

public abstract class Node {
    @Getter
    protected final Node parent;

    @Getter
    protected final String name;

    protected Node(Node parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public abstract long getSize();

    public abstract boolean isDirectory();
}
