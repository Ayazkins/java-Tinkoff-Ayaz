package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @DisplayName("Big sample test : ((()))(())()()(()())")
    @Test
    void SampleTest() {
        ArrayList<String> output = Task2.clusterize("((()))(())()()(()())");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(new String[] {"((()))", "(())", "()", "()", "(()())"}));
        assertThat(output).isEqualTo(expected);
    }

    @DisplayName("Not balanced input test")
    @Test
    void WrongInputTest() {
        try {
            Task2.clusterize("(()");
        }
        catch (Throwable e) {
            assertThat(e.getMessage()).isEqualTo("Wrong input");
        }
    }
}
