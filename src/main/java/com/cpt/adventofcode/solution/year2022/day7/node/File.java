package com.cpt.adventofcode.solution.year2022.day7.node;

public class File extends Node {
    private final long size;

    protected File(Node parent, String name, Long size) {
        super(parent, name);
        this.size = size;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}
