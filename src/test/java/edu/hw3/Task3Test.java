package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @DisplayName("Sample test with String")
    @Test
    void SampleTest() {
        Map<String, Integer> output = Task3.freqDict(new String[] {"bb", "a", "bb", "a"});
        Map<String, Integer> expected = new HashMap<>();
        expected.put("bb", 2);
        expected.put("a", 2);
        assertThat(output).isEqualTo(expected);
    }
}
