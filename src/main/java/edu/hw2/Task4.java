package edu.hw2;

public class Task4 {

    private static final int NUMBER_IN_STACK = 2;
    public static CallingInfo callingInfo() {
        StackTraceElement[] stktrace
            = Thread.currentThread().getStackTrace();
        return new CallingInfo(stktrace[NUMBER_IN_STACK].getClassName(), stktrace[NUMBER_IN_STACK].getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
