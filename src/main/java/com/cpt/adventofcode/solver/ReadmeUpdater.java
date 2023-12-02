package com.cpt.adventofcode.solver;

import com.google.common.io.Files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ReadmeUpdater {

    public static void replaceReadmeResults(String results) throws IOException {
        String readmeContent = getReadmeContent();

        Pattern pattern = Pattern.compile("```results.*```", Pattern.DOTALL);
        readmeContent = pattern.matcher(readmeContent).replaceFirst("```results\n" + results + "```");


        System.out.println(readmeContent);
    }


    private static String getReadmeContent() throws IOException {
        Path path = getRelativePath("README.md");
        return String.join("\n", Files.readLines(path.toFile(), Charset.defaultCharset()));
    }

    private static Path getRelativePath(String... subpaths) {
        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        return Paths.get(root.toString(), subpaths);
    }
}
