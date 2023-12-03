package edu.hw8.Task2;

import java.util.AbstractMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FibonacciCounter implements Runnable {
    private final int number;
    public static CopyOnWriteArrayList<AbstractMap.SimpleEntry<Integer, Integer>> arrayList =
        new CopyOnWriteArrayList<>();
    public int out;

    public FibonacciCounter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int fib = calculateFibonacci(number);
        out = fib;
        arrayList.add(new AbstractMap.SimpleEntry<>(number, fib));
    }

    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}
