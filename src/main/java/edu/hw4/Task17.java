package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task17 {
    private Task17() {

    }

    public static Boolean spidersBiteMoreThanDogs(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        Map<Animal.Type, Integer> map = animals.stream()
            .filter(animal -> (animal.type().equals(Animal.Type.DOG)
                || animal.type().equals(Animal.Type.SPIDER))
                && animal.bites())
        .collect(Collectors.toMap(Animal::type, e -> 1, Integer::sum));
        if (map.get(Animal.Type.SPIDER) > map.get(Animal.Type.DOG)) {
            return true;
        }
        return false;
    }
}
