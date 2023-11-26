package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void multiThreadCounter() {
        ThreadSafeCounter a = new ThreadSafeCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                a.incrementCounter();
        }});
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                a.incrementCounter();
            }});
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ignored) {
        }
        assertEquals(a.getCounter(), 20);
    }
}
