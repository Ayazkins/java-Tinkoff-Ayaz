package edu.hw2.Task3;

public final class FailureChecker {

    private FailureChecker() {

    }

    public static boolean shouldItFail(double chanceOfFaulty) {
        return Math.random() < chanceOfFaulty;
    }
}
