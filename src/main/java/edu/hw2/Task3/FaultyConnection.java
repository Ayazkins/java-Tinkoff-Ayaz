package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    private final double chanceOfFaulty = 0.5;

    public Throwable execute(String command) {
        if (!FailureChecker.shouldItFail(chanceOfFaulty)) {
            LOGGER.info("Success");
        } else {
            throw new ConnectionException();
        }
        return null;
    }

    public void close() {
        LOGGER.info("Connection is closed");
    }
}
