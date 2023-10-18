package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private final static Logger LOGGER = LogManager.getLogger();

    private final static String INPUT_STRING = "The word: ";

    private final static int MAX_MISTAKES = 5;
    private final Word word;

    private int mistakes;

    public Game(WordDictionary wordDictionary) {
        word = new Word(wordDictionary);
        mistakes = 0;
    }

    public Result launch() {
        if (word.length() < 2) {
            return new Result.FailedStart();
        }
        boolean running = true;
        while (running) {
            LOGGER.info("Guess a letter:");
            Scanner scanner = new Scanner(System.in);
            String in = scanner.nextLine();
            var result = takeChar(in);
            if (!(result instanceof Result.Right || result instanceof Result.Wrong)) {
                return result;
            }
        }
        return new Result.Finish();
    }

    public Result takeChar(String in) {
        if (in.equals("exit")) {
            return new Result.StopPlaying();
        }
        if (in.length() != 1) {
            LOGGER.info("Incorrect");
            return new Result.Go();
        }
        char ch = in.charAt(0);
        if (word.tryChar(ch)) {
            return goodGuess();
        } else {
            return badGuess();
        }
    }

    private Result goodGuess() {
        LOGGER.info("Hit!");
        LOGGER.info(INPUT_STRING + word.getCurWord());
        if (word.isWordFull()) {
            LOGGER.info("You won!");
            return new Result.Win();
        }
        return new Result.Right();
    }

    private Result badGuess() {
        mistakes += 1;
        LOGGER.info("Missed, mistake " + mistakes + " out of " + word.length());
        LOGGER.info(INPUT_STRING + word.getCurWord());
        if (mistakes == MAX_MISTAKES) {
            LOGGER.info("You lost!");
            return new Result.Defeat();
        }
        return new Result.Wrong();
    }
}
