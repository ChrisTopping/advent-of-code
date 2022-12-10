package com.cpt.adventofcode.solution.year2022.day7.prompt.command;

import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;

public class CommandFactory {

    public static BackDirectoryCommand back(Prompt next) {
        return new BackDirectoryCommand(next);
    }

    public static ChangeDirectoryCommand changeDirectory(Prompt next, String directory) {
        return new ChangeDirectoryCommand(next, directory);
    }

    public static ListCommand list(Prompt next) {
        return new ListCommand(next);
    }
}
