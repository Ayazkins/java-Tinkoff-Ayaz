package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task7 {
    private Task7() {

    }

    public static boolean isNotLessThatThreeHasZeroAtIndexZero(String a) {
        String regex = "^[01]{2}0[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        return matcher.matches();
    }

    public static boolean isStartsAndEndsWithOneSymbol(String a) {
        String regex = "^(0[01]*0)|(1[01]*1)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        return matcher.matches();
    }

    public static boolean isLengthMoreThanOneAndLessThanFour(String a) {
        String regex = "^[01]{1,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(a);
        return matcher.matches();
    }
}
