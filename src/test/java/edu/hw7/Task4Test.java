package edu.hw7;

import edu.hw7.Task4.MonteKarloPiCounter;
import edu.hw7.Task4.PiCounter;
import edu.hw7.Task4.MultiThreadPiCounter;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    public void countTimeTest() {
        MonteKarloPiCounter piCounter = new PiCounter();
        MonteKarloPiCounter multiThreadCounter = new MultiThreadPiCounter();
        int[] points = new int[] {10_000_000, 100_000_000, 1_000_000_000};
        System.out.println("One thread");
        for (int a : points) {
            countTimeAndValue(piCounter, a);
        }
        System.out.println();
        System.out.println("Multi thread");
        for (int a : points) {
            countTimeAndValue(multiThreadCounter, a);
        }
    }

    private void countTimeAndValue(MonteKarloPiCounter counter, int amounts) {
        System.out.println("Points: " + amounts);
        long start = System.currentTimeMillis();
        System.out.println("Pi: " + counter.countPi(amounts));
        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));
    }
}
