package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @DisplayName("Backward iterator test")
    @Test
    void backwardTest() {
        Iterator<Integer> iterator = new BackwardIterator<Integer>(List.of(1, 2, 3, 4, 5));
        for (int i = 4; i >= 0; --i) {
            assertThat(iterator.next()).isEqualTo(i + 1);
        }
        assertThat(iterator.hasNext()).isEqualTo(false);
    }
}
