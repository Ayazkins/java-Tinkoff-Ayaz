package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Фильтрация четных чисел")
    void filterEvenNumbers() {
        // given
        int[] numbers = new int[] {1, 2, 3, 4, 5};

        // when
        int[] evenNumbers = EvenArrayUtils.filter(numbers);

        // then
        assertThat(evenNumbers)
            .containsExactly(2, 4)
            .hasSize(2);
    }

    @Test
    @DisplayName("Время в секунды")
    void MinutesToSeconds() {
        String test1 = "01:00";
        assertThat(Task1.minutesToSeconds(test1)).isEqualTo(60);
        test1 = "13:56";
        assertThat(Task1.minutesToSeconds(test1)).isEqualTo(836);
        test1 = "10:60";
        assertThat(Task1.minutesToSeconds(test1)).isEqualTo(-1);
    }
}
