package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("The number is 6174")
    void countKOf6174() {
        int number = 6174;

        int actual = Task6.countK(number);
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("FIrst test from example")
    void countKFromExample() {
        int number = 6621;

        int actual = Task6.countK(number);
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Second test from example")
    void countKFromExample2() {
        int number = 6554;

        int actual = Task6.countK(number);
        int expected = 4;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("SameDigits")
    void countKOfNumberWithZeroes() {
        int number = 1111;

        int actual = Task6.countK(number);
        int expected = -1;

        assertThat(actual).isEqualTo(expected);
    }
}
