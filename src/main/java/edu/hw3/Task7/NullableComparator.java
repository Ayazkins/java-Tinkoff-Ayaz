package edu.hw3.Task7;

import java.util.Comparator;
import org.jetbrains.annotations.Nullable;


public class NullableComparator implements Comparator<String> {
    public int compare(@Nullable String string1, @Nullable String string2) {
        if (string1 == null && string2 == null) {
            return 0;
        }
        if (string1 == null) {
            return 1;
        }
        if (string2 == null) {
            return -1;
        }
        return string1.compareTo(string2);
    }
}
