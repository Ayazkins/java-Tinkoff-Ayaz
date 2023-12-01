package edu.hw7.Task4;

import java.util.Random;

public class PiCounter implements MonteKarloPiCounter {
    private static final double COEFF = 4.0;

    public double countPi(int amountsOfPoints) {
        int circleCount = 0;
        Random random = new Random();
        for (int i = 0; i < amountsOfPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }

        return COEFF * circleCount / amountsOfPoints;
    }
}
