package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    public void oddLengthTest() {
        assertTrue(Task8.oddLength("101"));
        assertFalse(Task8.oddLength("10"));
    }

    @Test
    public void startsWith0OddLengthOrStartsWith1EvenLengthTest() {
        assertTrue(Task8.startWithZeroAndOddOrStartsWithOne("01001"));
        assertTrue(Task8.startWithZeroAndOddOrStartsWithOne("1111"));
        assertFalse(Task8.startWithZeroAndOddOrStartsWithOne("01"));
        assertFalse(Task8.startWithZeroAndOddOrStartsWithOne("111"));
    }

    @Test
    public void multipleOf3ZerosTest() {
        assertTrue(Task8.amountOfZeroDividedByThree("00011"));
        assertTrue(Task8.amountOfZeroDividedByThree("1100101000"));
        assertFalse(Task8.amountOfZeroDividedByThree("00111"));
        assertFalse(Task8.amountOfZeroDividedByThree("10100011"));
    }

    @Test
    public void no111Or11Test() {
        assertTrue(Task8.noInRowForThreeAndTwo("01010"));
        assertTrue(Task8.noInRowForThreeAndTwo("100101"));
        assertFalse(Task8.noInRowForThreeAndTwo("111"));
        assertFalse(Task8.noInRowForThreeAndTwo("11"));
    }

    @Test
    public void oddCharacterEqualTo1Oneest() {
        assertTrue(Task8.everyOddNUmberIsOne("01010111"));
        assertTrue(Task8.everyOddNUmberIsOne("110101"));
        assertFalse(Task8.everyOddNUmberIsOne("001111"));
        assertFalse(Task8.everyOddNUmberIsOne("010110"));
    }

    @Test
    public void AtLeastTwoZerosAndNoMoreThanOneOneTest() {
        assertTrue(Task8.moreThanOneZeroLessThanTwoOne("001"));
        assertTrue(Task8.moreThanOneZeroLessThanTwoOne("0000"));
        assertFalse(Task8.moreThanOneZeroLessThanTwoOne("10"));
        assertFalse(Task8.moreThanOneZeroLessThanTwoOne("0001111"));
    }

    @Test
    public void noConsecutiveonestTest() {
        assertTrue(Task8.noOneInRow("1010101"));
        assertTrue(Task8.noOneInRow("000000"));
        assertFalse(Task8.noOneInRow("101011"));
        assertFalse(Task8.noOneInRow("0011100"));
    }
}
