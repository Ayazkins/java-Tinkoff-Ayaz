package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private static final int K_NUMBER = 6174;
    private static final int MINIMUM = 1000;
    private static final int MAXIMUM = 10000;

    private static final int AMOUNT_OF_DIGITS = 4;
    private static final int DIVISION_TEN = 10;
    private static final int THIRD_DIGIT = 100;
    private static final int FOURTH_DIGIT = 1000;



    private Task6() {

    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int inputNumber) {
        if (inputNumber == K_NUMBER) {
            return 0;
        }
        int number = inputNumber;
        if (isNotSameDigits(number) || number <= MINIMUM || number >= MAXIMUM) {
            return -1;
        }
        int[] array = new int[AMOUNT_OF_DIGITS];
        for (int i = 0; i < AMOUNT_OF_DIGITS; ++i) {
            array[i] = number % DIVISION_TEN;
            number /= DIVISION_TEN;
        }
        Arrays.sort(array);
        int minNumber = array[0] * FOURTH_DIGIT + array[1] * THIRD_DIGIT + array[2] * DIVISION_TEN + array[3];
        int maxNumber = array[3] * FOURTH_DIGIT + array[2] * THIRD_DIGIT + array[1] * DIVISION_TEN + array[0];
        if (maxNumber - minNumber == K_NUMBER) {
            return 1;
        } else {
            return 1 + countK(maxNumber - minNumber);
        }
    }

    private static boolean isNotSameDigits(int number) {
        char[] arrayChar = Integer.toString(number).toCharArray();
        for (int i = 1; i < arrayChar.length; ++i) {
            if (arrayChar[i] != arrayChar[i - 1]) {
                return false;
            }
        }
        return true;
    }


}
