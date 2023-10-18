package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HandledManTest {
    @Test
    @DisplayName("Incorrect Word")
    void IncorrectWordTest() {
        var dict = new WordDictionary();
        dict.addWord("a");
        var game = new Game(dict);
        assertThat(game.launch() instanceof Result.FailedStart).isEqualTo(true);
    }

    @Test
    @DisplayName("Defeat")
    void DefeatTest() {
        var dict = new WordDictionary();
        dict.addWord("coffee");
        var game = new Game(dict);
        game.takeChar("q");
        game.takeChar("q");
        game.takeChar("q");
        game.takeChar("q");
        game.takeChar("q");
        assertThat(game.takeChar("q") instanceof Result.Defeat).isEqualTo(true);
    }

    @Test
    @DisplayName("Right behavior")
    void RightBehaviorTest() {
        var dict = new WordDictionary();
        dict.addWord("coffee");
        var game = new Game(dict);
        assertThat(game.takeChar("q") instanceof Result.Wrong).isEqualTo(true);
        assertThat(game.takeChar("c") instanceof Result.Right).isEqualTo(true);
    }

    @Test
    @DisplayName("Typo")
    void TypoTest() {
        var dict = new WordDictionary();
        dict.addWord("coffee");
        var game = new Game(dict);
        assertThat(game.takeChar("qc") instanceof Result.Wrong).isEqualTo(false);
    }




}
