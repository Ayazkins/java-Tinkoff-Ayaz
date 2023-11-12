package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void durationCalculateTest() {
        List<String>
            input =
            List.of(new String[] {"2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"});
        Duration answer = Task1.calculateDuration(input);
        Duration expected = Duration.ofMinutes(220);
        assertEquals(answer, expected);

    }
}
