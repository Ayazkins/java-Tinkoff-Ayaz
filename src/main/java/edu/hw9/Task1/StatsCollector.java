package edu.hw9.Task1;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class StatsCollector {
    public static final int MAX_VALUE_INDEX = 3;
    public static final int MIN_VALUE_INDEX = 2;
    public static final int SUM_INDEX = 1;
    public static final int AVERAGE_INDEX = 0;
    private final ExecutorService consumers;

    private final ExecutorService produsers;

    private final BlockingQueue<AbstractMap.SimpleEntry<String, double[]>> queue;

    public StatsCollector(int produceThreadsAmount, int consumerThreadsAmount) {
        consumers = Executors.newFixedThreadPool(produceThreadsAmount);
        produsers = Executors.newFixedThreadPool(consumerThreadsAmount);
        queue = new LinkedBlockingQueue<>();
    }

    public void push(String name, double[] array) throws ExecutionException, InterruptedException {
        var a = produsers.submit(new Producer(name, array, queue));
        if (!a.get()) {
            throw new InterruptedException();
        }
    }

    public Map<String, StatsData> stats() throws InterruptedException, ExecutionException {
        List<AbstractMap.SimpleEntry<String, double[]>> answers = new ArrayList<>();
        while (!queue.isEmpty()) {
            Consumer consumer = new Consumer(queue);
            answers.add(consumers.submit(consumer).get());
        }
        Map<String, StatsData> output = new HashMap<>();
        for (var toMap : answers) {
            StatsData statsData =
                new StatsData(toMap.getValue()[AVERAGE_INDEX],
                    toMap.getValue()[SUM_INDEX],
                    toMap.getValue()[MIN_VALUE_INDEX],
                    toMap.getValue()[MAX_VALUE_INDEX]);
            output.put(toMap.getKey(), statsData);
        }

        return output;
    }
}
