package com.cpt.adventofcode.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemScraper {

    public static String getDescription(String year, String day) throws IOException {
        Document doc = fetch(year, day);
        return doc.select("html > body > main > article > h2")
                .text()
                .replace("--- Day " + day + ": ", "")
                .replace(" ---", "");
    }

    public static List<String> getExampleInputs(String year, String day) throws IOException {
        Document doc = fetch(year, day);
        return doc.select("html > body > main > article > pre > code")
                .stream()
                .map(Element::text)
                .collect(Collectors.toList());
    }

    private static Document fetch(String year, String day) throws IOException {
        String url = String.format("https://adventofcode.com/%s/day/%s", year, day);
        return Jsoup.connect(url).get();
    }
}
