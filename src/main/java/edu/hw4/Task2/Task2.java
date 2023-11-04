package edu.hw4.Task2;import edu.hw4.Animal;import java.util.List;public final class Task2 {    private Task2() {    }    public static List<Animal> weightSort(List<Animal> list, int amount) {        if (list == null) {            throw new IllegalArgumentException("List should not be empty");        }        return list.stream().sorted(new WeightComparator()).limit(amount).toList();    }}