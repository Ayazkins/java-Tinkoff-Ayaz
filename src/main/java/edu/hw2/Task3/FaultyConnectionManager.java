package edu.hw2.Task3;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
