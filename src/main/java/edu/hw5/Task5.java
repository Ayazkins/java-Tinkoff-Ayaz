package edu.hw5;

public final class Task5 {
    private Task5() {}

    public static boolean isValidNumber(String licensePlate) {
        return licensePlate.matches("^[А-Я]{1}\\d{3}[А-Я]{2}\\d{3}$");
    }
}
