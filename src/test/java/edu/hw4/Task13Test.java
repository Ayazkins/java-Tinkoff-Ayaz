package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task13Test {
    @Test
    public void namesWithTwoOrMoreWordsTest() {
        Animal a = new Animal("Dog boy", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true);
        Animal b = new Animal("Dog", Animal.Type.CAT, Animal.Sex.F, 2, 60, 50, true);
        Animal c = new Animal("Bird bird bird", Animal.Type.BIRD, Animal.Sex.F, 2, 70, 20, true);
        Animal d = new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 5, 80, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        List<Animal> animals = Task13.namesTwoWords(test);
        for (Animal animal: animals) {
            assertTrue(animal.name().split(" ").length >= 2);
        }
    }
}
