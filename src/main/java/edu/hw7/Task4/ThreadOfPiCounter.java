package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadOfPiCounter extends Thread {
    private int amountOfPoints;
    private int circleCount;

    public ThreadOfPiCounter(int simulations) {
        this.amountOfPoints = simulations;
        circleCount = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < amountOfPoints; i++) {
            double x = ThreadLocalRandom.current().nextDouble(0, 1);
            double y = ThreadLocalRandom.current().nextDouble(0, 1);
            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }
    }

    public int getCirclePoints() {
        return circleCount;
    }
}
