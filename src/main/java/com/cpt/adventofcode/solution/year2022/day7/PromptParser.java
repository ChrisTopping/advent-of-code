package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.solution.year2022.day5.CommandParser;
import com.cpt.adventofcode.solution.year2022.day7.prompt.*;
import com.cpt.adventofcode.solution.year2022.day7.prompt.command.BackDirectoryCommand;
import com.cpt.adventofcode.solution.year2022.day7.prompt.command.ChangeDirectoryCommand;
import com.cpt.adventofcode.solution.year2022.day7.prompt.command.CommandFactory;
import com.cpt.adventofcode.solution.year2022.day7.prompt.command.ListCommand;
import com.cpt.adventofcode.solution.year2022.day7.prompt.result.DirectoryResult;
import com.cpt.adventofcode.solution.year2022.day7.prompt.result.FileResult;
import com.cpt.adventofcode.solution.year2022.day7.prompt.result.ResultFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromptParser {
    public static Prompt parse(List<String> input) {
        String current = input.get(0);
        Prompt next = input.size() == 1 ? null : parse(input.subList(1, input.size()));
        if (isCommand(current)) {
            if (isBackDirectoryCommand(current)) {
                return CommandFactory.back(next);
            } else if (isChangeDirectoryCommand(current)) {
                return CommandFactory.changeDirectory(next, getDirectoryNameFromChangeDirectoryCommand(current));
            } else {
                return CommandFactory.list(next);
            }
        } else {
            if (isDirectoryResult(current)) {
                return ResultFactory.directory(next, getDirectoryNameFromDirectoryResult(current));
            } else {
                return ResultFactory.file(next, getFileNameFromFileResult(current), getFileSizeFromFileResult(current));
            }
        }
    }

    private static boolean isCommand(String input) {
        return input.startsWith("$");
    }

    private static boolean isBackDirectoryCommand(String input) {
        return input.startsWith("$ cd ..");
    }

    private static boolean isChangeDirectoryCommand(String input) {
        return input.startsWith("$ cd");
    }

    private static boolean isDirectoryResult(String input) {
        return input.startsWith("dir ");
    }

    private static String getDirectoryNameFromChangeDirectoryCommand(String input) {
        Matcher matcher = Pattern.compile("\\$ cd (.*)").matcher(input);
        matcher.find();
        return matcher.group(1);
    }

    private static String getDirectoryNameFromDirectoryResult(String input) {
        Matcher matcher = Pattern.compile("dir (.*)").matcher(input);
        matcher.find();
        return matcher.group(1);
    }

    private static String getFileNameFromFileResult(String input) {
        Matcher matcher = Pattern.compile("(.*) (.*)").matcher(input);
        matcher.find();
        return matcher.group(2);
    }

    private static long getFileSizeFromFileResult(String input) {
        Matcher matcher = Pattern.compile("(.*) (.*)").matcher(input);
        matcher.find();
        return Long.parseLong(matcher.group(1));
    }
}
