package com.cpt.adventofcode.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ProblemScraper {

    public static String getProblemDescription(String year, String day) throws IOException {
        String url = String.format("https://adventofcode.com/%s/day/%s", year, day);
        Document doc = Jsoup.connect(url).get();
        return doc.select("html > body > main > article > h2")
                .text()
                .replace("--- Day " + day + ": ", "")
                .replace(" ---", "");
    }
}
