package edu.hw1;

public final class Task5 {

    private Task5() {
    }

    private static final int TEN_NUMBER_SYSTEM = 10;

    private static boolean isPalindrome(char[] number) {
        for (int i = 0; i < number.length / 2; ++i) {
            if (number[i] != number[number.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static char[] makeNewNumber(char[] number) {
        int newNumber = 0;
        for (int i = 0; i < number.length - 1; i += 2) {
            int first = Character.getNumericValue(number[i]);
            int second = Character.getNumericValue(number[i + 1]);
            newNumber *= TEN_NUMBER_SYSTEM;

            if (first + second >= TEN_NUMBER_SYSTEM) {
                newNumber *= TEN_NUMBER_SYSTEM;
            }
            newNumber += first + second;
        }
        return Integer.toString(newNumber).toCharArray();
    }

    public static boolean isPalindromeDescendant(int number) {
        char[] charNumber = Integer.toString(number).toCharArray();
        while (charNumber.length >= 2) {
            if (isPalindrome(charNumber)) {
                return true;
            }
            charNumber = makeNewNumber(charNumber);
        }
        return false;
    }
}
