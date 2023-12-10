package edu.hw9.Task1;

import java.util.AbstractMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Producer implements Callable<Boolean> {
    private final BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue;

    private final String name;

    private final double[] values;

    public Producer(String name, double[] values, BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue) {
        this.queue = queue;
        this.name = name;
        this.values = values;
    }

    private boolean produce() {
        queue.add(new AbstractMap.SimpleEntry<>(name, values));
        return true;
    }

    @Override
    public Boolean call() throws Exception {
        return produce();
    }
}
