package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class Task18 {
    private Task18() {

    }

    public static Animal heaviestFish(List<Animal> l1, List<Animal> l2, List<Animal>... additionalLists) {
        List<List<Animal>> animals = new ArrayList<>();
        animals.add(l1);
        animals.add(l2);
        animals.addAll(Arrays.asList(additionalLists));
        for (var a : animals) {
            if (a == null) {
                throw new IllegalArgumentException("List should not be empty");
            }
        }
        return animals.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
