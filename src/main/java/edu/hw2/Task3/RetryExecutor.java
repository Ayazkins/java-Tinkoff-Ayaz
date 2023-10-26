package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryExecutor {

    private final int maxAttempts;

    public RetryExecutor(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        curAttempt = 0;
    }

    public int curAttempt;

    private final static Logger LOGGER = LogManager.getLogger();

    public void execute(Throwable exception) {
        if (exception != null) {
            curAttempt += 1;
        }
        if (curAttempt == maxAttempts) {
            throw new ConnectionException();
        }
    }
}
