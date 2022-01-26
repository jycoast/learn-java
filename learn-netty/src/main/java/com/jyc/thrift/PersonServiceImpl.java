package com.jyc.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got client param: " + username);
        return new Person().setUsername(username).setAge(20).setMarried(false);
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got client param: " + person);
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
    }
}
