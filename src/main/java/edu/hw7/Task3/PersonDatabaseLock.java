package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabaseLock implements PersonDatabase {
    private final Map<Integer, Person> personMap = new HashMap<>();
    private final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    private final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    private final Map<String, Set<Integer>> phoneIndex = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            personMap.put(person.id(), person);
            nameIndex.computeIfAbsent(person.name(), k -> ConcurrentHashMap.newKeySet()).add(person.id());
            addressIndex.computeIfAbsent(person.address(), k -> ConcurrentHashMap.newKeySet()).add(person.id());
            phoneIndex.computeIfAbsent(person.phoneNumber(), k -> ConcurrentHashMap.newKeySet()).add(person.id());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = personMap.remove(id);
            if (person != null) {
                nameIndex.getOrDefault(person.name(), Collections.emptySet()).remove(id);
                addressIndex.getOrDefault(person.address(), Collections.emptySet()).remove(id);
                phoneIndex.getOrDefault(person.phoneNumber(), Collections.emptySet()).remove(id);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            Set<Integer> ids = nameIndex.getOrDefault(name, Collections.emptySet());
            return findPersonsByIds(ids);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            Set<Integer> ids = addressIndex.getOrDefault(address, Collections.emptySet());
            return findPersonsByIds(ids);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            Set<Integer> ids = phoneIndex.getOrDefault(phone, Collections.emptySet());
            return findPersonsByIds(ids);
        } finally {
            lock.readLock().unlock();
        }
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
