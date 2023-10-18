package edu.hw2.Task3;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;

public class DefaultConnectionManager implements ConnectionManager {
    public Connection getConnection() {
        if ((Math.random() * 2) > 1.8) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
