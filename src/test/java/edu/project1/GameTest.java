package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
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
}
