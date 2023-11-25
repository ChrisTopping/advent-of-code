package com.cpt.adventofcode.solution.year2015.day4;

import java.security.MessageDigest;

public class Miner {

    public static long mine(String seed, int zeros) {
        String check = "0".repeat(zeros);
        long index = 0;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            while (true) {
                String key = String.format("%s%d", seed, ++index);
                byte[] digest = md.digest(key.getBytes());
                if (toHexString(digest).startsWith(check))
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte value : bytes) {
            result.append(Integer.toString((value & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
