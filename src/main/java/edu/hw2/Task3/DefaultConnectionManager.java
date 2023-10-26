package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {

    private final double chanceOfFaulty = 0.8;

    public Connection getConnection() {
        if (FailureChecker.shouldItFail(chanceOfFaulty)) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
