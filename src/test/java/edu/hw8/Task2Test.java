package edu.hw8;

import edu.hw8.Task2.FibonacciCounter;
import edu.hw8.Task2.FixedThreadPool;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void fibonacciCounterTest() throws InterruptedException {
        int numThreads = 10;
        int numFibonacci = 30;
        FibonacciCounter[] fib = new FibonacciCounter[numFibonacci];


        try (FixedThreadPool threadPool = new FixedThreadPool(numThreads)) {
            threadPool.start();
            for (int i = 0; i < numFibonacci; i++) {
                final int n = i;
                FibonacciCounter fibonacciCounter = new FibonacciCounter(n);
                fib[i] = fibonacciCounter;
                threadPool.execute(fibonacciCounter);
            }
        }
        assertEquals(0, fib[0].out);
        assertEquals(1, fib[1].out);
        for (int i = 2; i < fib.length; ++i) {
            assertEquals(fib[i-2].out + fib[i-1].out, fib[i].out);
        }
    }
}
