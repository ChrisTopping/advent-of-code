package com.cpt.adventofcode.solution.year2022.day7.node;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

public class Directory extends Node {
    @Getter
    private Collection<Node> children = new ArrayList<>();

    protected Directory(Node parent, String name) {
        super(parent, name);
    }

    @Override
    public long getSize() {
        return children.stream()
                .mapToLong(Node::getSize)
                .sum();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }
}
