package edu.hw4;

import edu.hw4.Task2.Task2;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    @Test
    void weightSortTest() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 20, 5, true));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 5, 30, 10, true));
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 1, false));
        animals.add(new Animal("Fish", Animal.Type.FISH, Animal.Sex.M, 2, 5, 0, false));

        List<Animal> sortedAnimals = Task2.weightSort(animals, 2);

        assertEquals(2, sortedAnimals.size());
        Animal previousAnimal = null;
        for (Animal animal : sortedAnimals) {
            if (previousAnimal != null) {
                assertTrue(animal.weight() <= previousAnimal.weight());
            }
            previousAnimal = animal;
        }
    }
}
