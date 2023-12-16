package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.Calculators.ActualFibCalculator;
import edu.hw10.Task2.Calculators.FibCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    private static final String[] ANSWERS = new String[] {
        "fib [0]:0",
        "fib [1]:1",
        "fib [2]:1",
        "fib [3]:2",
        "fib [4]:3",
        "fib [5]:5",
        "fib [6]:8",
        "fib [7]:13",
        "fib [8]:21",
        "fib [9]:34"
    };

    @Test
    public void cacheTest() throws IOException {
        Path tempDir = Files.createTempDirectory("testDir");
        var tempFile = Files.createTempFile(tempDir, "test", null);

        FibCalculator calculator = new ActualFibCalculator();
        FibCalculator proxy = CacheProxy.create(calculator, FibCalculator.class, tempFile.toString());
        for (int i = 0; i < 10; i++) {
            proxy.fib(i);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toString()))) {
            for (int i = 0; i < 10; ++i) {
                assertEquals(ANSWERS[i], reader.readLine());
            }
        }

        Files.deleteIfExists(tempFile);
        Files.deleteIfExists(tempDir);
    }
}
