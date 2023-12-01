package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void calculateFactorialTest() {
        long number = 5;
        long expectedFactorial = 120;
        long factorial = FactorialCounter.calculateFactorial(number);
        assertEquals(expectedFactorial, factorial);
    }
}
