package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void findAllFriday13thTest() {
        List<LocalDate> localDates = Task2.findFriday13th(2024);
        List<LocalDate> expected = List.of(new LocalDate[]{LocalDate.of(2024, Month.SEPTEMBER, 13), LocalDate.of(2024,Month.DECEMBER,13)});
        assertEquals(localDates, expected);
    }

    @Test
    public void findNextFriday13thTest() {
        LocalDate localDates = Task2.nextFriday13th(LocalDate.of(2024, Month.JANUARY, 1));
        assertEquals(localDates, LocalDate.of(2024, Month.SEPTEMBER, 13));
    }
}
