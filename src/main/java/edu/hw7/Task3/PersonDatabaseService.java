package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PersonDatabaseService implements PersonDatabase {
    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    private final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    private final Map<String, Set<Integer>> phoneIndex = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        personMap.put(person.id(), person);
        nameIndex.computeIfAbsent(person.name(), k -> ConcurrentHashMap.newKeySet()).add(person.id());
        addressIndex.computeIfAbsent(person.address(), k -> ConcurrentHashMap.newKeySet()).add(person.id());
        phoneIndex.computeIfAbsent(person.phoneNumber(), k -> ConcurrentHashMap.newKeySet()).add(person.id());
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            synchronized (this) {
                nameIndex.getOrDefault(person.name(), Collections.emptySet()).remove(id);
                addressIndex.getOrDefault(person.address(), Collections.emptySet()).remove(id);
                phoneIndex.getOrDefault(person.phoneNumber(), Collections.emptySet()).remove(id);
            }
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        Set<Integer> ids = nameIndex.getOrDefault(name, Collections.emptySet());
        return findPersonsByIds(ids);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        Set<Integer> ids = addressIndex.getOrDefault(address, Collections.emptySet());
        return findPersonsByIds(ids);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        Set<Integer> ids = phoneIndex.getOrDefault(phone, Collections.emptySet());
        return findPersonsByIds(ids);
    }

    private synchronized List<Person> findPersonsByIds(Set<Integer> ids) {
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
