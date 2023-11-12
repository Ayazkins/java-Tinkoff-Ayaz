package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task17Test {
    @Test
    public void spidersBitesMoreThanDogsTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true);
        Animal b = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 2, 60, 50, false);
        Animal c = new Animal("Bird", Animal.Type.SPIDER, Animal.Sex.F, 2, 70, 20, true);
        Animal d = new Animal("Bird2", Animal.Type.SPIDER, Animal.Sex.M, 5, 80, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        Boolean output = Task17.spidersBiteMoreThanDogs(test);
        assertTrue(output);
        test.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true));
        test.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true));
        output = Task17.spidersBiteMoreThanDogs(test);
        assertFalse(output);
    }
}
