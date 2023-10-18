package edu.hw1;

import edu.hw2.Task1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw2.Task4.callingInfo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();





    private Main() {
    }

    public static void main(String[] args) {
        LOGGER.info(callingInfo().className());
    }
}
