package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    public void validTest() {
        assertTrue(Task6.isSubsequence("abc", "achfdbaabgabcaabg"));
    }

    @Test
    public void invalidTest() {
        assertFalse(Task6.isSubsequence("def", "achfdbaabgabcaabg"));
    }
}
