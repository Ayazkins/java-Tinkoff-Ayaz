package edu.hw7.Task3;

import java.util.List;


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
