package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task18 {
    private Task18() {

    }

    public static Animal heaviestFish(List<List<Animal>> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
