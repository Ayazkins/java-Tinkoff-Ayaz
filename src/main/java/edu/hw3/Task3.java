package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public final class Task3 {
    private Task3() {

    }

    public static <T> Map<T, Integer> freqDict(T[] input) {
        Map<T, Integer> dict = new HashMap<>();
        for (T a : input) {
            dict.put(a, dict.getOrDefault(a, 0) + 1);
        }
        return dict;
    }
}
