package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    public void validCarNumbersTest() {
        assertTrue(Task5.isValidNumber("А123ВЕ777"));
        assertTrue(Task5.isValidNumber("О777ОО177"));
    }

    @Test
    public void invalidCarNumbersTest() {
        assertFalse(Task5.isValidNumber("123АВЕ777"));
        assertFalse(Task5.isValidNumber("А123ВГ77"));
        assertFalse(Task5.isValidNumber("А123ВЕ7777"));
    }
}

