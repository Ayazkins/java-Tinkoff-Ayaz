package edu.hw2.Task3;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        int numberTry = 0;
        while (numberTry < maxAttempts) {
            numberTry += 1;
            Connection connection = manager.getConnection();
            try {
                connection.execute(command);
                LOGGER.info("Command was executed");
                return;
            } catch (ConnectionException a) {
                LOGGER.info("failed");
            }
            connection.close();
        }
        throw new ConnectionException("Failed");
    }
}
