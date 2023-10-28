package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public final class Task3 {
    private Task3() {

    }

    public static <T> Map<T, Integer> freqDict(T[] input) {
        Map<T, Integer> dict = new HashMap<>();
        for (T a: input) {
            if (dict.containsKey(a)) {
                Integer newInt = dict.get(a) + 1;
                dict.replace(a, newInt);
            } else {
                dict.put(a, 1);
            }
        }
        return dict;
    }
}
