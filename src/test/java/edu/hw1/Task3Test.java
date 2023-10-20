package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Simple test with return true")
    void ExampleTestOne() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 6};

        boolean actual = Task3.isNestable(arr1, arr2);
        boolean expected = true;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Simple test with return false")
    void ExampleTestTwo() {
        int[] nestedArr = {9, 9, 8};
        int[] arr = {8, 9};

        boolean actual = Task3.isNestable(nestedArr, arr);
        boolean expected = false;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Null array")
    void NullArray() {
        int[] nestedArr = {};
        int[] arr = {8, 9};

        boolean actual = Task3.isNestable(nestedArr, arr);
        boolean expected = false;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Array with negative values")
    void NegativeValues() {
        int[] nestedArr = {-5, 0};
        int[] arr = {8, 9};

        boolean actual = Task3.isNestable(nestedArr, arr);
        boolean expected = false;

        assertThat(actual).isEqualTo(expected);
    }


}
