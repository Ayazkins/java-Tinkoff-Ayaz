package edu.hw3;

import edu.hw3.Task7.NullableComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @DisplayName("Null test")
    @Test
    void NullTest() {
        TreeMap<String, String> map = new TreeMap<>(new NullableComparator());
        map.put(null, "hello");
        map.put("1", "2");
        assertThat(map.containsKey(null)).isEqualTo(true);
        assertThat(map.get(null)).isEqualTo("hello");
    }
}
