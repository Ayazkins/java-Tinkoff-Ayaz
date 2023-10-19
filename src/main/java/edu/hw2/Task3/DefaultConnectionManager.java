package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {

    private final static double CHANCE_OF_FAULTY = 1.8;

    public Connection getConnection() {
        if (Random.getRandom() > CHANCE_OF_FAULTY) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
