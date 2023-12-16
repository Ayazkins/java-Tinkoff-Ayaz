package edu.hw10;

import edu.hw10.Task1.ObjectGenerator;
import edu.hw10.Task1.Objects.GrownUpPerson;
import edu.hw10.Task1.Objects.GrownUpPersonRecord;
import edu.hw10.Task1.RandomValuesGenerator.RandomGenerator;
import edu.hw10.Task1.RandomValuesGenerator.RandomIntegerGenerator;
import edu.hw10.Task1.RandomValuesGenerator.RandomStringGenerator;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    public void objectCreationTest() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, RandomGenerator<?>> randomGeneratorMap = new HashMap<>();
        randomGeneratorMap.put("int", new RandomIntegerGenerator());
        randomGeneratorMap.put("java.lang.String", new RandomStringGenerator());
        ObjectGenerator objectGenerator = new ObjectGenerator(randomGeneratorMap);
        var person = objectGenerator.nextObject(GrownUpPersonRecord.class);
        assertThat(person.name() != null);
        assertThat(person.age() >= 18 && person.age() <= 199);
        GrownUpPerson person1 = objectGenerator.nextObject(GrownUpPerson.class);
        assertThat(person1.getName() != null);
        assertThat(person1.getAge() >= 18 && person1.getAge() <= 199);
        person1 = objectGenerator.nextObject(GrownUpPerson.class, "create");
        assertThat(person1.getName() != null);
        assertThat(person1.getAge() >= 18 && person1.getAge() <= 199);
    }
}
