package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    private final static double CHANCE_OF_FAULTY = 0.5;

    public void execute(String command) {
        if (!FailureChecker.shouldItFail(CHANCE_OF_FAULTY)) {
            LOGGER.info("Success");
        } else {
            throw new ConnectionException();
        }
    }

    public void close() {
        LOGGER.info("Connection is closed");
    }
}
