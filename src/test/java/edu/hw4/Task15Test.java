package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task15Test {
    @Test
    public void sumOfWeightsTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true);
        Animal b = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 60, 50, true);
        Animal c = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 6, 70, 20, true);
        Animal d = new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 5, 80, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        Map<Animal.Type, Integer> map  = Task15.sumWeights(test, 3, 7);
        assertEquals(map.get(Animal.Type.BIRD), 30);
        assertEquals(map.get(Animal.Type.DOG), 50);
    }
}
