package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw2.Task4.callingInfo;

public class Task4Test {
    @Test
    @DisplayName("callingInfo from test")
    void callingInfoTest() {
        var info = callingInfo();
        assertThat(info.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(info.methodName()).isEqualTo("callingInfoTest");

    }
}
