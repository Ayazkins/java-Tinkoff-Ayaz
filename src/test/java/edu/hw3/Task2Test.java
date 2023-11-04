package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @DisplayName("Big sample test : ((()))(())()()(()())")
    @Test
    void sampleTest() {
        List<String> output = Task2.clusterize("((()))(())()()(()())");
        List<String> expected =
            new ArrayList<>(Arrays.asList(new String[] {"((()))", "(())", "()", "()", "(()())"}));
        assertThat(output).isEqualTo(expected);
    }

    @DisplayName("Not balanced input test")
    @Test
    void wrongInputTest() {
        try {
            Task2.clusterize("(()");
        } catch (Throwable e) {
            assertThat(e.getMessage()).isEqualTo("Wrong input");
        }
    }
}
