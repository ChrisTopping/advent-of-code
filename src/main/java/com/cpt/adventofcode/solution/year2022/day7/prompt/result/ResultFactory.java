package com.cpt.adventofcode.solution.year2022.day7.prompt.result;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;

public class ResultFactory {
    public static FileResult file(Prompt next, String name, long siz) {
        return new FileResult(next, name, siz);
    }

    public static DirectoryResult directory(Prompt next, String name) {
        return new DirectoryResult(next, name);
    }
}
