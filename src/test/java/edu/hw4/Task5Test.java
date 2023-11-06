package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    public void sexCompareTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 1, 50, 10, true);
        Animal b = new Animal("Car", Animal.Type.CAT, Animal.Sex.F, 1, 60, 10, true);
        Animal c = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 1, 70, 10, true);
        Animal d = new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 1, 70, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        assertEquals(Animal.Sex.F, Task5.compareDiffSex(test));
    }
}
