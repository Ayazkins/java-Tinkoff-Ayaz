package edu.project1;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HandledManTest {
    @Test
    @DisplayName("Incorrect Word")
    void IncorrectWordTest() {
        var dict = new WordDictionary();
        dict.AddWord("a");
        var game = new Game(dict);
        assertThat(game.Launch() instanceof Result.FailedStart).isEqualTo(true);
    }

    @Test
    @DisplayName("Defeat")
    void DefeatTest() {
        var dict = new WordDictionary();
        dict.AddWord("coffee");
        var game = new Game(dict);
        game.TakeChar("q");
        game.TakeChar("q");
        game.TakeChar("q");
        game.TakeChar("q");
        game.TakeChar("q");
        assertThat(game.TakeChar("q") instanceof Result.Defeat).isEqualTo(true);
    }

    @Test
    @DisplayName("Right behavior")
    void RightBehaviorTest() {
        var dict = new WordDictionary();
        dict.AddWord("coffee");
        var game = new Game(dict);
        assertThat(game.TakeChar("q") instanceof Result.Wrong).isEqualTo(true);
        assertThat(game.TakeChar("c") instanceof Result.Right).isEqualTo(true);
    }

    @Test
    @DisplayName("Typo")
    void TypoTest() {
        var dict = new WordDictionary();
        dict.AddWord("coffee");
        var game = new Game(dict);
        assertThat(game.TakeChar("qc") instanceof Result.Wrong).isEqualTo(false);
    }




}
