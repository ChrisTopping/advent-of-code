package com.cpt.adventofcode.scraper;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;


public class InputScraper {

    public static void main(String[] args) throws IOException {
        System.out.println(getInput("2020", "1"));
    }

    public static Stream<String> getInput(String year, String day) throws IOException {
        String session = Dotenv.load().get("SESSION");

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("https://adventofcode.com/%s/day/%s/input", year, day))
                .addHeader("Cookie", "session=" + session)
                .build();

        Response response = client.newCall(request)
                .execute();

        return Arrays.stream(Objects.requireNonNull(response.body()).string().split("\n"));
    }
}
