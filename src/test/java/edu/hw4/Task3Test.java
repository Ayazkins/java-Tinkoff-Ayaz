package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    public void typeTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 1, 50, 10, true);
        Animal b = new Animal("Car", Animal.Type.CAT, Animal.Sex.M, 1, 60, 10, true);
        Animal c = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 70, 10, true);
        Animal d = new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 1, 70, 10, true);

        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        Map<Animal.Type, Integer> map = Task3.countTypes(test);
        assertEquals(2, (int) map.get(Animal.Type.BIRD));
        assertEquals(1, (int) map.get(Animal.Type.CAT));
        assertEquals(1, (int) map.get(Animal.Type.DOG));

    }
}
