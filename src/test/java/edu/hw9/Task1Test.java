package edu.hw9;

import edu.hw9.Task1.Consumer;
import edu.hw9.Task1.Producer;
import edu.hw9.Task1.StatsCollector;
import edu.hw9.Task1.StatsData;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void statsCollectorTest() throws InterruptedException, ExecutionException {
        StatsCollector statsCollector = new StatsCollector(2, 3);
        statsCollector.push("metric_name", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        statsCollector.push("metric_name_2", new double[] {0.1, 0.05, 10, 5.1, 0.3});

        var check = statsCollector.stats();
        assertEquals(check.get("metric_name").getAverage(), 1.39);
        assertEquals(check.get("metric_name").getMax(), 5.1);
        assertEquals(check.get("metric_name").getMin(), 0.05);
        assertEquals(check.get("metric_name").getSum(), 6.949999999999999);

        assertEquals(check.get("metric_name_2").getAverage(), 3.1100000000000003);
        assertEquals(check.get("metric_name_2").getMax(), 10.0);
        assertEquals(check.get("metric_name_2").getMin(), 0.05);
        assertEquals(check.get("metric_name_2").getSum(), 15.55);
    }
}
