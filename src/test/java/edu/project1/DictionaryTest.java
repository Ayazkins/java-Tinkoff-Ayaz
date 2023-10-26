package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {
    @Test
    @DisplayName("Dictionary tests")
    void DictionaryTest() {
        var dict = new DefaultDictionary();
        dict.addWord("coffee");
        assertThat(dict.generate()).isEqualTo("coffee");
        dict.addWord("test");
        String value = dict.generate();
        assertThat(value.equals("test") || value.equals("coffee")).isEqualTo(true);

    }
}
