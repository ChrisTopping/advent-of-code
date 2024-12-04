package com.cpt.adventofcode.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strings {

    public static String join(Stream<String> stream) {
        return stream.collect(Collectors.joining(""));
    }

    public static List<String> toList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    public static List<Object> parse(String input, String delimiter, List<ParserParameter> parserParameters) {

        String[] elements = input.split(delimiter);
        List<Object> values = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            values.add(parserParameters.get(i).parse(elements[i]));
        }

        return values;
    }

    public static <T extends Object> List<T> splitAndCast(String input, String delimeter, Type type) {
        return (List<T>) Arrays
                .stream(input.split(delimeter))
                .map(type::cast)
                .collect(Collectors.toList());
    }

    public static Map<String, Object> parse(String input, ItemMatcher itemMatcher) {
        Map<String, Object> results = new HashMap<>();
        Pattern pattern = Pattern.compile(itemMatcher.pattern);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        itemMatcher.typeMap.forEach((key, value1) -> {
            String result = matcher.group(key);
            Object value = result == null ? value1.getDefaultValue() : value1.cast(result);
            results.put(key, value);
        });

        return results;
    }

    public static Map<String, List<Object>> parseAll(String input, ItemMatcher itemMatcher) {
        Map<String, List<Object>> results = new HashMap<>();
        Pattern pattern = Pattern.compile(itemMatcher.pattern);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            itemMatcher.typeMap.forEach((key, value1) -> {
                String result = matcher.group(key);
                Object value = result == null ? value1.getDefaultValue() : value1.cast(result);
                List<Object> previous = results.getOrDefault(key, new ArrayList<>());
                previous.add(value);
                results.put(key, previous);
            });
        }

        return results;
    }

    @AllArgsConstructor
    public static class ItemMatcher {
        private String pattern;
        private Map<String, Type> typeMap;
    }

    @Builder
    @Getter
    public static class ParserParameter {
        private List<String> substringsToIgnore;
        private Integer initialCharactersToIgnore;
        private Integer finalCharactersToIgnore;
        private Type type;

        public Object parse(String input) {
            if (initialCharactersToIgnore != null) {
                input = input.substring(initialCharactersToIgnore);
            }

            if (finalCharactersToIgnore != null) {
                input = input.substring(0, input.length() - finalCharactersToIgnore);
            }

            if (substringsToIgnore != null) {
                for (String ignore : substringsToIgnore) {
                    input = input.replace(ignore, "");
                }
            }

            return type.cast(input);
        }

    }

    public enum Type {
        STRING(""),
        INTEGER(0),
        LONG(0L),
        FLOAT(0F),
        DOUBLE(0D),
        BOOLEAN(false);

        private final Object defaultValue;

        Type(Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        public Object getDefaultValue() {
            return defaultValue;
        }

        public <T> T cast(String input) {
            return (T) switch (this) {
                case STRING -> input;
                case  INTEGER -> Integer.parseInt(input);
                case LONG -> Long.parseLong(input);
                case FLOAT -> Float.parseFloat(input);
                case DOUBLE -> Double.parseDouble(input);
                case BOOLEAN -> Boolean.parseBoolean(input);
            };
        }
    }


}
