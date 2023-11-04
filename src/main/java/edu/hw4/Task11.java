package edu.hw4;

import java.util.List;

public final class Task11 {
    private static final int HEIGHT = 100;

    private Task11() {

    }

    public static List<Animal> canBiteAndHeightMoreThanHundred(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > HEIGHT)
            .toList();
    }
}
