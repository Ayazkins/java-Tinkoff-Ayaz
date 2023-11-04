package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task12Test {
    @Test
    public void weightMoreThanHeightTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true);
        Animal b = new Animal("Dog", Animal.Type.CAT, Animal.Sex.F, 2, 60, 50, true);
        Animal c = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 2, 10, 20, true);
        Animal d = new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 5, 5, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        int amount = Task12.weightMoreThatHeight(test);
        assertEquals(2, amount);
    }
}
