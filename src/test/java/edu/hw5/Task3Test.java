package edu.hw5;

import org.junit.jupiter.api.Test;
import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    public void goodFormatsTest() {
        Optional<LocalDate> result = Task3.parseData("2020-10-10");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.of(2020, 10, 10), result.get());

        result = Task3.parseData("2020-12-2");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.of(2020, 12, 2), result.get());

        result = Task3.parseData("1/3/1976");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.of(1976, 1, 3), result.get());

        result = Task3.parseData("1/3/20");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.of(2020, 1, 3), result.get());

        result = Task3.parseData("tomorrow");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().plusDays(1), result.get());

        result = Task3.parseData("today");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now(), result.get());

        result = Task3.parseData("yesterday");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().minusDays(1), result.get());

        result = Task3.parseData("1 day ago");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().minusDays(1), result.get());

        result = Task3.parseData("2234 days ago");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().minusDays(2234), result.get());
    }


    @Test
    public void badFormatsTest() {
        Optional<LocalDate> result = Task3.parseData("2021-13-01");
        assertFalse(result.isPresent());

        result = Task3.parseData("abc");
        assertFalse(result.isPresent());
    }
}
