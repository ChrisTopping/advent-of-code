package com.cpt.adventofcode.helpers;

import java.util.List;

public class Maths {

    public static long gcd(long x, long y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    public static long gcd(List<Long> numbers) {
        return numbers.stream().reduce(0L, Maths::gcd);
    }

    public static long lcm(List<Long> numbers) {
        return numbers.stream().reduce(1L, (x, y) -> x * (y / gcd(x, y)));
    }
}
