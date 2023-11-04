package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task18Test {
    @Test
    public void heaviesFishTest() {
        Animal a = new Animal("Dog", Animal.Type.FISH, Animal.Sex.F, 1, 50, 10, true);
        Animal b = new Animal("Dog", Animal.Type.FISH, Animal.Sex.F, 2, 60, 50, false);
        Animal c = new Animal("Bird", Animal.Type.SPIDER, Animal.Sex.F, 2, 70, 20, true);
        Animal d = new Animal("Bird2", Animal.Type.FISH, Animal.Sex.M, 5, 80, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        Animal a1 = new Animal("Dog", Animal.Type.FISH, Animal.Sex.F, 1, 50, 10, true);
        Animal b1 = new Animal("Dog", Animal.Type.FISH, Animal.Sex.F, 2, 60, 60, false);
        Animal c1 = new Animal("Bird", Animal.Type.SPIDER, Animal.Sex.F, 2, 70, 20, true);
        Animal d1 = new Animal("Bird2", Animal.Type.FISH, Animal.Sex.M, 5, 80, 10, true);
        List<Animal> test2 = new ArrayList<>();
        Collections.addAll(test2, a1, b1, c1, d1);
        List<List<Animal>> input = new ArrayList<>();
        input.add(test);
        input.add(test2);
        Animal fish = Task18.heaviestFish(input);
        assertEquals(b1, fish);
    }
}
