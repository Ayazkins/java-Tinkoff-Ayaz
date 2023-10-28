package edu.hw3;

import edu.hw3.Task5.Parse;
import edu.hw3.Task5.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @DisplayName("Sample test")
    @Test
    void SampleTest() {
        ArrayList<Person> output = Parse.parseContacts
            (new String[] {"John Locke", "Thomas Aquinas"}, "ASC");
        ArrayList<Person> expected = new ArrayList<>();
        expected.add(new Person("Thomas", "Aquinas"));
        expected.add(new Person("John", "Locke"));
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).name).isEqualTo(expected.get(i).name);
            assertThat(output.get(i).surname).isEqualTo(expected.get(i).surname);
        }
        output = Parse.parseContacts(new String[] {"John Locke", "Thomas Aquinas"}, "DESC");
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).name).isEqualTo(expected.get(expected.size() - 1 - i).name);
            assertThat(output.get(i).surname).isEqualTo(expected.get(expected.size() - 1 - i).surname);
        }
    }

    @DisplayName("No surname test")
    @Test
    void NoSurnameTest() {
        ArrayList<Person> output = Parse.parseContacts
            (new String[] {"John Locke", "Aquinas"}, "ASC");
        ArrayList<Person> expected = new ArrayList<>();
        expected.add(new Person("Aquinas", null));
        expected.add(new Person("John", "Locke"));
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).name).isEqualTo(expected.get(i).name);
        }
        output = Parse.parseContacts(new String[] {"John Locke", "Aquinas"}, "DESC");
        for (int i = 0; i < output.size(); ++i) {
            assertThat(output.get(i).name).isEqualTo(expected.get(expected.size() - 1 - i).name);
        }
    }

}
