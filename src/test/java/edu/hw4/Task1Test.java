package edu.hw4;

import edu.hw4.Task1.Task1;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    public void defaultValuesTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 1, 50, 10, true );
        Animal b = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 1, 60, 10, true );
        Animal c = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.M, 1, 70, 10, true );

        List<Animal> list = new ArrayList<>();
        list.add(b);
        list.add(a);
        list.add(c);
        List<Animal> sortedAnimals = Task1.heightSort(list);

        Animal previousAnimal = null;
        for (Animal animal : sortedAnimals) {
            if (previousAnimal != null) {
                assertTrue(animal.height() >= previousAnimal.height());
            }
            previousAnimal = animal;
        }
    }
}
