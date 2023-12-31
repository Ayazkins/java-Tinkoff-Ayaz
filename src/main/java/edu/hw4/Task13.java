package edu.hw4;

import java.util.List;

public final class Task13 {
    private Task13() {

    }

    public static List<Animal> namesTwoWords(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }
}
