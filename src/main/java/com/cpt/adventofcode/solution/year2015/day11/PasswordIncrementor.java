package com.cpt.adventofcode.solution.year2015.day11;

public class PasswordIncrementor {

    private static final String INVALID_CHARACTERS = "iol";

    public static String getNextValid(String password) {
        boolean isValid = false;
        while (!isValid) {
            password = increment(password);
            isValid = isValid(password);
        }
        return password;
    }

    private static String increment(String previous) {
        if (previous.charAt(previous.length() - 1) == 'z') {
            return increment(previous.substring(0, previous.length() - 1)) + 'a';
        } else {
            char lastCharacter = (char) (previous.charAt(previous.length() - 1) + 1);
            return previous.substring(0, previous.length() - 1) + lastCharacter;
        }
    }

    private static boolean isValid(String input) {
        return hasIncreasingStraight(input)
                && hasNoInvalidChars(input)
                && hasTwoDistinctPairs(input);
    }

    private static boolean hasIncreasingStraight(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            char first = input.charAt(i);
            char second = input.charAt(i + 1);
            char third = input.charAt(i + 2);
            if (second == first + 1 && third == second + 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNoInvalidChars(String input) {
        for (char c : input.toCharArray()) {
            if (INVALID_CHARACTERS.indexOf(c) >= 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasTwoDistinctPairs(String input) {
        int pairsFound = 0;
        int i = 0;

        while (i < input.length() - 1) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                pairsFound++;
                i += 2;
                if (pairsFound >= 2) {
                    return true;
                }
            } else {
                i++;
            }
        }

        return false;
    }


}
