package edu.hw7.Task4;

public class MultiThreadPiCounter implements MonteKarloPiCounter {
    private static final int NUM_THREADS = 6;
    private static final double COEFF = 4.0;

    public double countPi(int totalPoints) {
        int circlePoints = 0;

        ThreadOfPiCounter[] threads = new ThreadOfPiCounter[NUM_THREADS];
        int part = totalPoints / NUM_THREADS;
        for (int i = 0; i < NUM_THREADS - 1; i++) {
            threads[i] = new ThreadOfPiCounter(part);
            threads[i].start();
        }
        threads[threads.length - 1] = new ThreadOfPiCounter(totalPoints - part * (NUM_THREADS - 1));
        threads[threads.length - 1].start();

        try {
            for (int i = 0; i < NUM_THREADS; i++) {
                threads[i].join();
                circlePoints += threads[i].getCirclePoints();
            }
        } catch (InterruptedException ignored) {

        }

        return COEFF * circlePoints / totalPoints;
    }
}
