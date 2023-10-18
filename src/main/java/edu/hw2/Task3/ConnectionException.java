package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    ConnectionException(String comment, Throwable cause) {
        super(comment, cause);
    }

    ConnectionException(String comment) {
        super(comment);
    }

    ConnectionException() {

    }
}
