package edu.hw1;

import java.util.OptionalInt;

public final class Task3 {
    private Task3() {
    }

    public static OptionalInt[] minAndMax(int[] array) {
        OptionalInt min = OptionalInt.empty();
        OptionalInt max = OptionalInt.empty();
        for (var val : array) {
            if (min.isEmpty() || val < min.getAsInt()) {
                min = OptionalInt.of(val);
            }
            if (max.isEmpty() || val > max.getAsInt()) {
                max = OptionalInt.of(val);
            }
        }
        return new OptionalInt[]{min, max};
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        OptionalInt minOfArray1;
        OptionalInt maxOfArray1;
        OptionalInt minOfArray2;
        OptionalInt maxOfArray2;
        OptionalInt[] results = minAndMax(array1);
        minOfArray1 = results[0];
        maxOfArray1 = results[1];
        OptionalInt[] results2 = minAndMax(array2);
        minOfArray2 = results2[0];
        maxOfArray2 = results2[1];

        if (minOfArray1.isEmpty() || maxOfArray2.isEmpty()) {
            return false;
        }
        return minOfArray1.getAsInt() > minOfArray2.getAsInt() && maxOfArray1.getAsInt() < maxOfArray2.getAsInt();
    }
}
