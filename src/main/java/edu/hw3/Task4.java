package edu.hw3;

import java.util.TreeMap;

public final class Task4 {
    private Task4() {

    }

    private final static int THOUSAND = 1000;
    private final static int NINE_HUNDRED = 900;
    private final static int FIVE_HUNDRED = 500;
    private final static int FOUR_HUNDRED = 400;
    private final static int HUNDRED = 100;
    private final static int NINETY = 90;
    private final static int FIFTY = 50;
    private final static int FOURTY = 40;
    private final static int TEN = 10;

    private final static int NINE = 9;
    private final static int FIVE = 5;
    private final static int FOUR = 4;
    private final static int ONE = 1;
    private final static TreeMap<Integer, String> DICT = new TreeMap<>();

    static {
        DICT.put(THOUSAND, "M");
        DICT.put(NINE_HUNDRED, "CM");
        DICT.put(FIVE_HUNDRED, "D");
        DICT.put(FOUR_HUNDRED, "CD");
        DICT.put(HUNDRED, "C");
        DICT.put(NINETY, "XC");
        DICT.put(FIFTY, "L");
        DICT.put(FOURTY, "XL");
        DICT.put(TEN, "X");
        DICT.put(NINE, "IX");
        DICT.put(FIVE, "V");
        DICT.put(FOUR, "IV");
        DICT.put(ONE, "I");
    }

    public static String convertToRoman(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Wrong number");
        }
        int closestToVal = DICT.floorKey(value);
        if (value == closestToVal) {
            return DICT.get(closestToVal);
        }
        return DICT.get(closestToVal) + convertToRoman(value - closestToVal);
    }
}
