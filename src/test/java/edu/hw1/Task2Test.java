package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("CorrectInput")
    void CorrectInput() {
        int a = 123456;
        int actual = Task2.countDigits(a);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Zero")
    void Zero() {
        int a = 0;
        int actual = Task2.countDigits(a);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test for minus number")
    void TestMinus() {
        int a = -1000;
        int actual = Task2.countDigits(a);
        int expected = 4;
        assertThat(actual).isEqualTo(expected);
    }

}
