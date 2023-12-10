package edu.hw9.Task1;

public class StatsData {
    private final double sum;
    private final double average;
    private final double min;
    private final double max;

    public StatsData(double sum, double average, double max, double min) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
