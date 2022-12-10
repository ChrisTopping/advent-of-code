package com.cpt.adventofcode.solution.year2022.day7;

import com.cpt.adventofcode.solution.year2022.day7.node.Directory;
import com.cpt.adventofcode.solution.year2022.day7.node.File;
import com.cpt.adventofcode.solution.year2022.day7.node.Node;
import com.cpt.adventofcode.solution.year2022.day7.node.NodeFactory;
import com.cpt.adventofcode.solution.year2022.day7.prompt.*;
import com.cpt.adventofcode.solution.year2022.day7.prompt.command.ChangeDirectoryCommand;
import com.cpt.adventofcode.solution.year2022.day7.prompt.result.DirectoryResult;
import com.cpt.adventofcode.solution.year2022.day7.prompt.result.FileResult;

import java.util.Collection;

public class NodeResolver {

    public static void resolve(Node parent, Prompt prompt) {
        if (prompt == null) return;
        switch (prompt.getType()) {
            case FILE -> {
                FileResult fileResult = (FileResult) prompt;
                File file = NodeFactory.file(parent, fileResult.getName(), fileResult.getSize());
                if (parent.isDirectory()) {
                    ((Directory) parent).addChild(file);
                }
                resolve(parent, prompt.getNext());
            }
            case DIRECTORY -> {
                DirectoryResult directoryResult = (DirectoryResult) prompt;
                Directory directory = NodeFactory.directory(parent, directoryResult.getName());
                ((Directory) parent).addChild(directory);
                resolve(parent, prompt.getNext());
            }
            case CHANGE_DIRECTORY -> {
                Collection<Node> children = ((Directory) parent).getChildren();
                Node next = children.stream()
                        .filter(Node::isDirectory)
                        .filter(child -> child.getName().equals(((ChangeDirectoryCommand) prompt).getDirectoryName()))
                        .findFirst()
                        .orElse(parent);
                resolve(next, prompt.getNext());
            }
            case BACK_DIRECTORY -> resolve(parent.getParent(), prompt.getNext());
            case LIST -> resolve(parent, prompt.getNext());
        }
    }
}
