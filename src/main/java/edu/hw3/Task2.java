package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Task2 {
    private final static char OPEN_BRACKET = '(';
    private final static char CLOSE_BRACKET = ')';

    private Task2() {

    }

    public static List<String> clusterize(String input) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> output = new ArrayList<>();
        StringBuilder curString = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if (c.equals(OPEN_BRACKET)) {
                stack.push(c);
                curString.append(c);
            }
            if (c.equals(CLOSE_BRACKET) && stack.firstElement().equals(OPEN_BRACKET)) {
                stack.pop();
                curString.append(c);
            }
            if (stack.isEmpty()) {
                output.add(curString.toString());
                curString = new StringBuilder();
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Wrong input");
        }
        return output;
    }
}
