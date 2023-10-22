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

    public Game(Dictionary wordDictionary) {
        word = new Word(wordDictionary);
        mistakes = 0;
    }

    public Result launch() {
        if (word.length() < 2) {
            return Result.FAILED_START;
        }
        Result running = Result.GO;
        while (running == Result.GO) {
            LOGGER.info("Guess a letter:");
            Scanner scanner = new Scanner(System.in);
            String in = scanner.nextLine();
            running = takeChar(in);
            if (running == Result.RIGHT || running == Result.WRONG) {
                running = Result.GO;
            }
        }
        return running;
    }

    public Result takeChar(String in) {
        if (in.equals("exit")) {
            return Result.STOP_PLAYING;
        }
        if (in.length() != 1) {
            LOGGER.info("Incorrect");
            return Result.GO;
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
            return Result.WIN;
        }
        return Result.RIGHT;
    }

    private Result badGuess() {
        mistakes += 1;
        LOGGER.info("Missed, mistake " + mistakes + " out of " + word.length());
        LOGGER.info(INPUT_STRING + word.getCurWord());
        if (mistakes == MAX_MISTAKES) {
            LOGGER.info("You lost!");
            return Result.DEFEAT;
        }
        return Result.WRONG;
    }
}
