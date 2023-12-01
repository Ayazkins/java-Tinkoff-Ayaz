package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class PersonDatabaseMethods {
    protected final Map<Integer, Person> personMap = new HashMap<>();
    protected final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    protected final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    protected final Map<String, Set<Integer>> phoneIndex = new HashMap<>();

    protected void addToBase(Person person) {
        personMap.put(person.id(), person);
        nameIndex.computeIfAbsent(person.name(), k -> new HashSet<>()).add(person.id());
        addressIndex.computeIfAbsent(person.address(), k -> new HashSet<>()).add(person.id());
        phoneIndex.computeIfAbsent(person.phoneNumber(), k -> new HashSet<>()).add(person.id());
    }

    protected void deleteFromBase(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            nameIndex.getOrDefault(person.name(), Collections.emptySet()).remove(id);
            addressIndex.getOrDefault(person.address(), Collections.emptySet()).remove(id);
            phoneIndex.getOrDefault(person.phoneNumber(), Collections.emptySet()).remove(id);
        }
    }

    protected List<Person> findByNameAbstract(String name) {
        Set<Integer> ids = nameIndex.getOrDefault(name, Collections.emptySet());
        return findPersonsByIds(ids);
    }

    protected List<Person> findByAddressAbstract(String address) {
        Set<Integer> ids = addressIndex.getOrDefault(address, Collections.emptySet());
        return findPersonsByIds(ids);
    }

    protected List<Person> findByPhoneAbstract(String phone) {
        Set<Integer> ids = phoneIndex.getOrDefault(phone, Collections.emptySet());
        return findPersonsByIds(ids);
    }

    private List<Person> findPersonsByIds(Set<Integer> ids) {
        List<Person> result = new ArrayList<>();
        for (int id : ids) {
            Person person = personMap.get(id);
            if (person != null) {
                result.add(person);
            }
        }
        return result;
    }
}
