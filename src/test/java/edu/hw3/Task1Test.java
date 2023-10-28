package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Sample test : \"Hello world!\"")
    void SampleTest() {
        String output = Task1.atbash("Hello world!");
        String expected = "Svool dliow!";
        assertThat(output).isEqualTo(expected);
    }

    @Test
    @DisplayName("Not alphabet char test")
    void NotAlphabetTest() {
        String output = Task1.atbash("1234");
        String expected = "1234";
        assertThat(output).isEqualTo(expected);
    }

    @Test
    @DisplayName("Empty word")
    void EmptyWordTest() {
        String output = Task1.atbash("");
        String expected = "";
        assertThat(output).isEqualTo(expected);
    }
}
