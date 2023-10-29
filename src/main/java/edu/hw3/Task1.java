package edu.hw3;

public final class Task1 {
    private static final int BIG_A = 65;
    private static final int BIG_Z = 90;

    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;

    private Task1() {
    }

    public static String atbash(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (isBigLetter(charArray[i])) {
                charArray[i] = calculateBigSymbol(charArray[i]);
            }
            if (isSmallLetter(charArray[i])) {
                charArray[i] = calculateSmallSymbol(charArray[i]);
            }
        }
        return String.valueOf(charArray);
    }

    private static boolean isBigLetter(char a) {
        return (a <= BIG_Z) && (a >= BIG_A);
    }

    private static boolean isSmallLetter(char a) {
        return (a <= SMALL_Z) && (a >= SMALL_A);
    }

    private static char calculateBigSymbol(char a) {
        return (char) (BIG_A + (BIG_Z - (int) a));
    }

    private static char calculateSmallSymbol(char a) {
        return (char) (SMALL_A + (SMALL_Z - (int) a));
    }
}
