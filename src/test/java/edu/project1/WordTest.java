package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordTest {
    @Test
    @DisplayName("Word class tests")
    void WordTest() {
        var dict = new DefaultDictionary();
        dict.addWord("coffee");
        var word = new Word(dict);
        assertThat(word.tryChar('c')).isEqualTo(true);
        assertThat(word.isWordFull()).isEqualTo(false);
        assertThat(word.getCurWord()).isEqualTo("c*****");
        assertThat(word.tryChar('f')).isEqualTo(true);
        assertThat(word.getCurWord()).isEqualTo("c*ff**");
    }
}
