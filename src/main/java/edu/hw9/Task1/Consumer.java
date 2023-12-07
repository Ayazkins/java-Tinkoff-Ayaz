package edu.hw9.Task1;

import java.util.AbstractMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer implements Callable<AbstractMap.SimpleEntry<String, double[]>> {
    private final BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue;

    private String name;

    public Consumer(BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue) {
        this.queue = queue;
    }

    public double sum;

    public double average;
    public double max;
    public double min = Double.MAX_VALUE;

    public String getName() {
        return name;
    }

    private AbstractMap.SimpleEntry<String, double[]> consume() {

        AbstractMap.SimpleEntry<String, double[]> pair = queue.poll();
        double[] working = pair.getValue();
        name = pair.getKey();
        for (int i = 0; i < working.length; ++i) {
            sum += working[i];
            if (working[i] < min) {
                min = working[i];
            }
            if (working[i] > max) {
                max = working[i];
            }
        }
        average = sum / working.length;
        return new AbstractMap.SimpleEntry<>(name, new double[] {sum, average, max, min});
    }

    @Override
    public AbstractMap.SimpleEntry<String, double[]> call() throws Exception {
        return consume();
    }
}
