package edu.hw7;

import java.util.stream.LongStream;

public final class FactorialCounter {
    private FactorialCounter() {

    }

    public static long calculateFactorial(long number) {
        return LongStream.rangeClosed(1, number)
            .parallel()
            .reduce(1, (acc, n) -> acc * n);
    }

}
