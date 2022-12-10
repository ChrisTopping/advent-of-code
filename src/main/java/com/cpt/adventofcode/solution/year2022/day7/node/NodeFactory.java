package com.cpt.adventofcode.solution.year2022.day7.node;

public class NodeFactory {
    public static Directory directory(Node parent, String name) {
        return new Directory(parent, name);
    }

    public static File file(Node parent, String name, long size) {
        return new File(parent, name, size);
    }
}
