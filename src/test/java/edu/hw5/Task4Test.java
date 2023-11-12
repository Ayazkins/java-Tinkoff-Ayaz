package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    public void validPasswordTest() {
        String password = "Abcd@123";
        assertTrue(Task4.isSymbolInPassword(password));
        password = "abcd!@#$";
        assertTrue(Task4.isSymbolInPassword(password));
        password = "pass^word";
        assertTrue(Task4.isSymbolInPassword(password));
    }

    @Test
    public void invalidPasswordTest() {
        String password = "123";
        assertFalse(Task4.isSymbolInPassword(password));
        password = "abcdefghijkl";
        assertFalse(Task4.isSymbolInPassword(password));
    }
}
