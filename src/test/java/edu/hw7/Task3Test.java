package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import edu.hw7.Task3.PersonDatabaseService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    public void personDatabaseCheck() {
        List<Person> personList = new ArrayList<>();
        Collections.addAll(
            personList,
            new Person(1, "person1", "2", "89813"),
            new Person(2, "person1", "3", "89813"),
            new Person(3, "person1", "2", "89813"),
            new Person(4, "person1", "4", "89813"),
            new Person(5, "person1", "3", "1356"),
            new Person(6, "person1", "1", "89813")
        );
        PersonDatabase he = new PersonDatabaseService();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < personList.size() / 2; ++i) {
                he.add(personList.get(i));
                for (var a : he.findByName("person1")) {
                    assertThat(a.address() != null);
                    assertThat(a.phoneNumber() != null);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = personList.size() / 2; i < personList.size(); ++i) {
                he.add(personList.get(i));
                for (var a : he.findByName("person1")) {
                    assertThat(a.address() != null);
                    assertThat(a.phoneNumber() != null);
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {

        }
        assertThat(he.findByName("person1").size() == 6);
        assertThat(he.findByName("2").size() == 2);
        assertThat(he.findByName("1356").size() == 1);
    }
}
