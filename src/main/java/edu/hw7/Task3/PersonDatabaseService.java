package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PersonDatabaseService extends PersonDatabaseMethods implements PersonDatabase {
    @Override
    public synchronized void add(Person person) {
        addToBase(person);
    }

    @Override
    public synchronized void delete(int id) {
        deleteFromBase(id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return findByNameAbstract(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return findByAddressAbstract(address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return findByPhoneAbstract(phone);
    }
}
