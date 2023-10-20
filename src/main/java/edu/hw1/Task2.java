package edu.hw1;

public final class Task2 {
    private Task2() {

    }

    private final static int TEN_NUMBER_SYSTEM = 10;

    public static int countDigits(int number) {
        int numberCopy = Math.abs(number);
        int counter = 0;
        do {
            ++counter;
            numberCopy /= TEN_NUMBER_SYSTEM;
        }
        while (numberCopy > 0);
        return counter;
    }
}
