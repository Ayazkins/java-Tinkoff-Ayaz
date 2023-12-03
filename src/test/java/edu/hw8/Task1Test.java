package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    public void clientAndServerTest() throws IOException, ExecutionException, InterruptedException {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        CompletableFuture<Void> serverStartFuture = CompletableFuture.runAsync(new Server(), executorService);
        Thread.sleep(2000);

        List<CompletableFuture<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Client client = new Client();
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return client.sendMessage("привет");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, executorService);
            futures.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        for (CompletableFuture<String> future : futures) {
            assertThat(future.get()).isEqualTo("Я не знаю, что сказать... Я сдаюсь");
        }
    }

}

