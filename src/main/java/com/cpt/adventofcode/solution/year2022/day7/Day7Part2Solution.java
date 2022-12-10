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
import java.util.stream.LongStream;
import java.util.stream.Stream;

@AdventOfCodeSolution(year = 2022, day = 7, part = 2,
        description = "No Space Left On Device",
        link = "https://adventofcode.com/2022/day/7#part2",
        tags = ""
)
public class Day7Part2Solution implements Solution<Long> {

    @Override
    public Long solve(Stream<String> inputStream) {
        Prompt prompt = PromptParser.parse(inputStream.collect(Collectors.toList()));
        Directory rootDirectory = NodeFactory.directory(null, "");
        rootDirectory.addChild(NodeFactory.directory(rootDirectory, "/"));
        NodeResolver.resolve(rootDirectory, prompt);

        long maxSize = 70000000L;
        long spaceRequired = 30000000L;

        long currentSizeTaken = rootDirectory.getSize();
        long currentSpace = maxSize - currentSizeTaken;

        long amountToRemove = spaceRequired - currentSpace;

        Node node = rootDirectory.getChildren().stream().findFirst().get();
        List<Directory> directoriesUnderSizeThreshold = findDirectoriesOverSizeThreshold(new ArrayList<>(), (Directory) node, amountToRemove);

        return directoriesUnderSizeThreshold.stream()
                .mapToLong(Directory::getSize)
                .min()
                .orElseThrow();
    }

    public List<Directory> findDirectoriesOverSizeThreshold(List<Directory> overThreshold, Directory directory, long threshold) {
        if (directory.getSize() > threshold) {
            overThreshold.add(directory);

            directory.getChildren()
                    .stream().filter(Node::isDirectory)
                    .map(node -> (Directory) node)
                    .forEach(childDirectory -> findDirectoriesOverSizeThreshold(overThreshold, childDirectory, threshold));
        }
        return overThreshold;
    }

}