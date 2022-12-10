package com.cpt.adventofcode.solution.year2022.day8;

import lombok.Getter;

class Tree {
    @Getter
    private final int height;
    @Getter
    boolean visible = false;
    @Getter
    int scenicScore = 1;

    public Tree(int height) {
        this.height = height;
    }

    public boolean isTallerThan(Tree other) {
        return other.height < this.height;
    }

    public Tree applyPreceding(Tree preceding) {
        if (preceding == null) {
            this.visible = true;
            return this;
        } else if (this.isTallerThan(preceding)) {
            return preceding;
        } else {
            this.visible = true;
            return this;
        }
    }

    public void multiplyScenicScore(int multiplier) {
        this.scenicScore *= multiplier;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "height=" + height +
                ", visible=" + visible +
                ", visibility=" + scenicScore +
                '}';
    }
}
