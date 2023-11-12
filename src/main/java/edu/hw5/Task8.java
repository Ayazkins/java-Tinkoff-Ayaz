package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task8 {
    private Task8() {

    }

    public static boolean oddLength(String s) {
        String regex = "^[01]([01]{2})+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean startWithZeroAndOddOrStartsWithOne(String s) {
        String regex = "^((^0([01]{2})*$)|(^1[01]([01]{2})*$))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean amountOfZeroDividedByThree(String s) {
        String regex = "^(1*01*01*01*)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean everyOddNUmberIsOne(String s) {
        String regex = "^([01]1)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean noOneInRow(String s) {
        String regex = "^(?![01]*(11))[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean noInRowForThreeAndTwo(String s) {
        String regex = "^(?!(11|111)$)[01]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean moreThanOneZeroLessThanTwoOne(String s) {
        String regex = "^(?!.*1.*1.*).*(0.*0.*).*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
