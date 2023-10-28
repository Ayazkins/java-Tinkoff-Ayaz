package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;

public final class Task2 {
    private Task2() {

    }

    public static ArrayList<String> clusterize(String input) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> output = new ArrayList<>();
        StringBuilder curString = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if (c.equals('(')) {
                stack.push(c);
                curString.append(c);
            }
            if (c.equals(')') && stack.firstElement().equals('(')) {
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
