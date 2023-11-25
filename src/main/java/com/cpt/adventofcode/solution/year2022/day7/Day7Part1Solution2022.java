package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.annotations.AdventOfCodeSolution;
import com.cpt.adventofcode.solution.Solution;
import com.cpt.adventofcode.solution.year2022.day7.node.Directory;
import com.cpt.adventofcode.solution.year2022.day7.node.Node;
import com.cpt.adventofcode.solution.year2022.day7.node.NodeFactory;
import com.cpt.adventofcode.solution.year2022.day7.prompt.Prompt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 7, part = 1,
        description = "No Space Left On Device",
        link = "https://adventofcode.com/2022/day/7",
        tags = ""
)
public class Day7Part1Solution2022 implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        Prompt prompt = PromptParser.parse(inputStream.collect(Collectors.toList()));
        Directory rootDirectory = NodeFactory.directory(null, "");
        rootDirectory.addChild(NodeFactory.directory(rootDirectory, "/"));
        NodeResolver.resolve(rootDirectory, prompt);

        List<Directory> directoriesUnderSizeThreshold = findDirectoriesUnderSizeThreshold(new ArrayList<>(), rootDirectory, 100000);
        return directoriesUnderSizeThreshold.stream().mapToLong(Directory::getSize).sum();
    }

    public List<Directory> findDirectoriesUnderSizeThreshold(List<Directory> underThreshold, Directory directory, long threshold) {
        if (directory.getSize() < threshold) {
            underThreshold.add(directory);
        }

        directory.getChildren()
                .stream().filter(Node::isDirectory)
                .map(node -> (Directory) node)
                .forEach(childDirectory -> findDirectoriesUnderSizeThreshold(underThreshold, childDirectory, threshold));
        return underThreshold;
    }

}