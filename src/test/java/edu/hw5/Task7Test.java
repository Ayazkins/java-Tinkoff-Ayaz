package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    public void zeroThirdTest() {
        assertTrue(Task7.isNotLessThatThreeHasZeroAtIndexZero("100"));
        assertFalse(Task7.isNotLessThatThreeHasZeroAtIndexZero("10"));
        assertTrue(Task7.isNotLessThatThreeHasZeroAtIndexZero("010110"));
    }

    @Test
    public void startsAndEndsWithOneSymbolTest() {
        assertTrue(Task7.isStartsAndEndsWithOneSymbol("010110"));
        assertFalse(Task7.isStartsAndEndsWithOneSymbol("100"));
        assertFalse(Task7.isStartsAndEndsWithOneSymbol("10"));
    }
    @Test
    public void lengthTest() {
        assertTrue(Task7.isLengthMoreThanOneAndLessThanFour("100"));
        assertTrue(Task7.isLengthMoreThanOneAndLessThanFour("10"));
        assertFalse(Task7.isLengthMoreThanOneAndLessThanFour("010110"));
    }
}
