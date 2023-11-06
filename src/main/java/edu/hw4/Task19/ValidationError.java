package edu.hw4.Task19;

public record ValidationError(String fieldName, String message) {

    @Override
    public String toString() {
        return fieldName + ": " + message;
    }
}
