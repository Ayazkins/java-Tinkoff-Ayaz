package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;

    private RetryExecutor retry;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        retry = new RetryExecutor(maxAttempts);
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) throws Exception {
        try (Connection connection = manager.getConnection()) {
            retry.execute(connection.execute(command));
        } catch (ConnectionException ex) {
            LOGGER.info("failed");
            retry = new RetryExecutor(retry.curAttempt);
            throw new ConnectionException("Failed");
        }
        tryExecute(command);
    }
}
