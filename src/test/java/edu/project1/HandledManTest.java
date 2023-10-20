package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HandledManTest {
    @Test
    @DisplayName("Incorrect Word")
    void IncorrectWordTest() {
        var dict = new DefaultDictionary();
        dict.addWord("a");
        var game = new Game(dict);
        assertThat(game.launch() == Result.FAILED_START).isEqualTo(true);
    }

    @Test
    @DisplayName("Defeat")
    void DefeatTest() {
        var dict = new DefaultDictionary();
        dict.addWord("coffee");
        var game = new Game(dict);
        game.takeChar("q");
        game.takeChar("q");
        game.takeChar("q");
        game.takeChar("q");
        assertThat(game.takeChar("q") == Result.DEFEAT).isEqualTo(true);
    }

    @Test
    @DisplayName("Right behavior")
    void RightBehaviorTest() {
        var dict = new DefaultDictionary();
        dict.addWord("coffee");
        var game = new Game(dict);
        assertThat(game.takeChar("q") == Result.WRONG).isEqualTo(true);
        assertThat(game.takeChar("c") == Result.RIGHT).isEqualTo(true);
    }

    @Test
    @DisplayName("Typo")
    void TypoTest() {
        var dict = new DefaultDictionary();
        dict.addWord("coffee");
        var game = new Game(dict);
        assertThat(game.takeChar("qc") == Result.GO).isEqualTo(true);
    }

    @Test
    @DisplayName("Word class tests")
    void WordTest() {
        var dict = new DefaultDictionary();
        dict.addWord("coffee");
        var word = new Word(dict);
        assertThat(word.tryChar('c')).isEqualTo(true);
        assertThat(word.isWordFull()).isEqualTo(false);
        assertThat(word.getCurWord()).isEqualTo("c*****");
    }

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
