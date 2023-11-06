package edu.hw3;

import edu.hw3.Task5.Parse;
import edu.hw3.Task5.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {    
    @DisplayName("Sample test")
    @Test
    void sampleTest() {
        List<Person> output = Parse.parseContacts
            (new String[] {"John Locke", "Thomas Aquinas"}, "ASC");
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Thomas", "Aquinas"));
        expected.add(new Person("John", "Locke"));
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).getName()).isEqualTo(expected.get(i).getName());
            assertThat(output.get(i).getSurname()).isEqualTo(expected.get(i).getSurname());
        }
        output = Parse.parseContacts(new String[] {"John Locke", "Thomas Aquinas"}, "DESC");
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).getName()).isEqualTo(expected.get(expected.size() - 1 - i).getName());
            assertThat(output.get(i).getSurname()).isEqualTo(expected.get(expected.size() - 1 - i).getSurname());
        }
    }

    @DisplayName("No surname test")
    @Test
    void noSurnameTest() {
        List<Person> output = Parse.parseContacts
            (new String[] {"John Locke", "Aquinas"}, "ASC");
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Aquinas", null));
        expected.add(new Person("John", "Locke"));
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).getName()).isEqualTo(expected.get(i).getName());
        }
        output = Parse.parseContacts(new String[] {"John Locke", "Aquinas"}, "DESC");
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).getName()).isEqualTo(expected.get(expected.size() - 1 - i).getName());
        }
    }

}
