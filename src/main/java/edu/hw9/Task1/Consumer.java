package edu.hw9.Task1;

import java.util.AbstractMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer implements Callable<AbstractMap.SimpleEntry<String, double[]>> {
    private final BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue;

    public Consumer(BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue) {
        this.queue = queue;
    }

    @Override
    public AbstractMap.SimpleEntry<String, double[]> call() {
        return consume();
    }

    private AbstractMap.SimpleEntry<String, double[]> consume() {
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = 0;
        double average;
        AbstractMap.SimpleEntry<String, double[]> pair = queue.poll();
        double[] working = pair.getValue();
        String name = pair.getKey();
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

}
