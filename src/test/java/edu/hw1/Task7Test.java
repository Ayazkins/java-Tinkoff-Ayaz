package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("rotateRight")
    void rotateRight() {
        int number = 8;
        int shift = 1;

        int actual = Task7.rotateRight(number, shift);
        int expected = 4;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("rotateLeft with minus")
    void rotateLeftWithMinus() {
        int number = 8;
        int shift = -1;

        int actual = Task7.rotateLeft(number, shift);
        int expected = 4;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("rotate left")
    void rotateLeft() {
        int number = 17;
        int shift = 2;

        int actual = Task7.rotateLeft(number, shift);
        int expected = 6;

        assertThat(actual).isEqualTo(expected);
    }
}
