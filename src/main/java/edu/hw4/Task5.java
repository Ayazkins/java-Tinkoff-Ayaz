package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task5 {
    private Task5() {

    }

    public static Animal.Sex compareDiffSex(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        Map<Animal.Sex, Integer> map =  animals.stream().collect(Collectors.toMap(Animal::sex, e -> 1, Integer::sum));
        if (map.get(Animal.Sex.M) > map.get(Animal.Sex.F)) {
            return Animal.Sex.M;
        }
        return Animal.Sex.F;
    }
}
