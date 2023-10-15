package edu.hw1;

public final class Task7 {
    private Task7() {

    }

    public static int rotateLeft(int number, int shift) {
        String binaryString = Integer.toBinaryString(number);
        int actualShift = shift;
        if (actualShift < 0) {
            return rotateRight(number, -actualShift);
        }
        actualShift %= binaryString.length();
        var output = binaryString.substring(actualShift) + binaryString.substring(0, actualShift);
        return Integer.parseInt(output, 2);
    }

    public static int rotateRight(int number, int shift) {
        String binaryString = Integer.toBinaryString(number);
        int actualShift = shift;
        if (actualShift < 0) {
            return rotateLeft(number, -actualShift);
        }
        actualShift %= binaryString.length();
        var output = binaryString.substring(binaryString.length() - actualShift)
            + binaryString.substring(0, binaryString.length() - actualShift);
        return Integer.parseInt(output, 2);
    }
}

