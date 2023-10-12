package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task1Test {

    @Test
    @DisplayName("Correct input")
    void CorrectInput() {
        String s = "88:08";
        int actual = Task1.minutesToSeconds(s);
        int expected = 88 * 60 + 8;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Incorrect input")
    void IncorrectInput() {
        String s = "88:88";
        int actual = Task1.minutesToSeconds(s);
        int expected = -1;
        assertThat(actual).isEqualTo(expected);

        s = "88:d";
        actual = Task1.minutesToSeconds(s);
        assertThat(actual).isEqualTo(expected);

        s = "88.08";
        actual = Task1.minutesToSeconds(s);
        assertThat(actual).isEqualTo(expected);

        s = null;
        actual = Task1.minutesToSeconds(s);
        assertThat(actual).isEqualTo(expected);
    }
}
