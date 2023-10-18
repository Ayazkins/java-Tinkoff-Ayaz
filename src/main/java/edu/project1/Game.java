package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private final static Logger LOGGER = LogManager.getLogger();

    private final Word word;

    private int mistakes;

    public Game() {
        var wordDictionary = new WordDictionary();
        word = new Word(wordDictionary);
        mistakes = 0;
    }

    public void Launch() {
        while (mistakes < word.Length()) {
            LOGGER.info("Guess a letter:");
            Scanner scanner = new Scanner(System.in);
            char ch = scanner.next().charAt(0);
            if (word.TryChar(ch)) {
                LOGGER.info("Hit!");
            }
            else {
                mistakes += 1;
                LOGGER.info("Missed, mistake " + mistakes + " out of " + word.Length());
            }
            LOGGER.info("The word: " + word.GetCurWord());
            if (word.IsWordFull()) {
                LOGGER.info("You won!");
                return;
            }
        }
        LOGGER.info("You lost!");
    }
}
