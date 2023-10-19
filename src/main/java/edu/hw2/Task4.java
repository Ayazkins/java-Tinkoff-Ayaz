package edu.hw2;

public final class Task4 {
    private static final int NUMBER_IN_STACK = 2;

    private Task4() {

    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stktrace
            = Thread.currentThread().getStackTrace();
        return new CallingInfo(stktrace[NUMBER_IN_STACK].getClassName(), stktrace[NUMBER_IN_STACK].getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
