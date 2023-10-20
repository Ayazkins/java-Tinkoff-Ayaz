package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryExecutor {

    private final static Logger LOGGER = LogManager.getLogger();

    public static boolean retry(ConnectionManager manager, String command) {
        try (Connection connection = manager.getConnection()) {
            connection.execute(command);
            return true;
        } catch (Exception ex) {
            LOGGER.info("failed");
        }
        return false;
    }
}
