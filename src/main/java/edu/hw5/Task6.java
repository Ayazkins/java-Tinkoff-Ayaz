package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {

    }

    public static boolean isSubsequence(String s, String t) {
        StringBuilder regex = new StringBuilder();
        regex.append("^.");
        for (var a : s.toCharArray()) {
            regex.append("*" + a + ".");
        }
        regex.append("*$");
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(t);
        return matcher.matches();
    }
}
