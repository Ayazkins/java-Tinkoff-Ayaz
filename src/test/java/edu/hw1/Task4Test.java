package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Amount of chars is even")
    void fixStringWithEvenNumberOfDigits() {
        String s = "badc";

        String receivedString = Task4.fixString(s);
        String expectedString = "abcd";

        assertThat(receivedString).isEqualTo(expectedString);
    }

    @Test
    @DisplayName("Amount of chars is odd")
    void fixStringWithOddNumberOfDigits() {
        String s = "badce";

        String receivedString = Task4.fixString(s);
        String expectedString = "abcde";

        assertThat(receivedString).isEqualTo(expectedString);
    }
}
