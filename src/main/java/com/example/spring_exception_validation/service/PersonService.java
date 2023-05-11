package com.example.spring_exception_validation.service;

import com.example.spring_exception_validation.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> listall();
    Person save(Person person);
    void deletebyid(long id);
    Person findbyid(long id);
}
