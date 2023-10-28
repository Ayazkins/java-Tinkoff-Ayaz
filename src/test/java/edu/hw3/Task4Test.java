package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @DisplayName("Simple test number 14")
    @Test
    void SimpleTest() {
        String output = Task4.convertToRoman(14);
        String expected = "XIV";
        assertThat(output).isEqualTo(expected);
    }

    @DisplayName("Simple test number 3")
    @Test
    void SimpleAmountOfOnesTest() {
        String output = Task4.convertToRoman(3);
        String expected = "III";
        assertThat(output).isEqualTo(expected);
    }

    @DisplayName("Wrong number test")
    @Test
    void WrongNumberTest() {
        try {
            Task4.convertToRoman(-5);
        }
        catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Wrong number");
        }
    }
}
