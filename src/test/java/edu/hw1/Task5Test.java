package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Simple test with return true")
    void ExampleTestOne() {
        int a = 11211230;
        boolean actual = Task5.isPalindromeDescendant(a);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Simple test with return false")
    void ExampleTestTwo() {
        int a = 114;
        boolean actual = Task5.isPalindromeDescendant(a);
        assertFalse(actual);
    }


}
