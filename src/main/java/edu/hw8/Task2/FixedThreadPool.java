package edu.hw8.Task2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedThreadPool implements ThreadPool {
    private final int numThreads;
    private final Thread[] threads;
    private final LinkedBlockingQueue<Runnable> queue;

    private final AtomicBoolean isShutdown;

    public FixedThreadPool(int numThreads) {
        this.numThreads = numThreads;
        threads = new Thread[numThreads];
        queue = new LinkedBlockingQueue<>();
        isShutdown = new AtomicBoolean(false);
    }

    public static FixedThreadPool create(int numThreads) {
        return new FixedThreadPool(numThreads);
    }

    @Override
    public void start() {
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isShutdown.get()) {
            throw new IllegalStateException("Cannot execute tasks on a stopped ThreadPool.");
        }
        queue.offer(runnable);
    }

    @Override
    public void close() throws InterruptedException {
        isShutdown.set(true);
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private final class Worker implements Runnable {
        @Override
        public void run() {
            while (!isShutdown.get() || !queue.isEmpty()) {
                Runnable task = queue.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }
}
