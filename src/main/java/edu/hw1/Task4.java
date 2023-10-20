package edu.hw1;

public final class Task4 {

    private Task4() {

    }

    public static String fixString(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < str.length() - str.length() % 2; i += 2) {
            char temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
        return new String(array);
    }
}
