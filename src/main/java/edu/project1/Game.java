package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private final static Logger LOGGER = LogManager.getLogger();

    private final static int MAX_MISTAKES = 5;
    private final Word word;

    private int mistakes;

    public Game(WordDictionary wordDictionary) {
        word = new Word(wordDictionary);
        mistakes = 0;
    }

    public Result Launch() {
        if (word.Length() < 2) {
            return new Result.FailedStart();
        }
        boolean running = true;
        while (running) {
            LOGGER.info("Guess a letter:");
            Scanner scanner = new Scanner(System.in);
            String in = scanner.nextLine();
            var result = TakeChar(in);
            if (!(result instanceof Result.Right || result instanceof Result.Wrong)) {
                return result;
            }
        }
        return new Result.Finish();
    }

    public Result TakeChar(String in) {
        if (in.equals("exit")) {
            return new Result.StopPlaying();
        }
        if (in.length() != 1) {
            LOGGER.info("Incorrect");
            return new Result.Go();
        }
        char ch = in.charAt(0);
        if (word.TryChar(ch)) {
            LOGGER.info("Hit!");
            LOGGER.info("The word: " + word.GetCurWord());
            if (word.IsWordFull()) {
                LOGGER.info("You won!");
                return new Result.Win();
            }
            return new Result.Right();
        } else {
            mistakes += 1;
            LOGGER.info("Missed, mistake " + mistakes + " out of " + word.Length());
            LOGGER.info("The word: " + word.GetCurWord());
            if (mistakes == MAX_MISTAKES) {
                LOGGER.info("You lost!");
                return new Result.Defeat();
            }
            return new Result.Wrong();
        }
    }
}
