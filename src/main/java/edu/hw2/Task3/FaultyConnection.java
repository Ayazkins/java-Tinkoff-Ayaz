package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    public void execute(String command) {
        if ((Math.random() * 2) > 1) {
            LOGGER.info("Success");
        } else {
            throw new ConnectionException();
        }
    }

    public void close() {
        LOGGER.info("Connection is closed");
    }
}
