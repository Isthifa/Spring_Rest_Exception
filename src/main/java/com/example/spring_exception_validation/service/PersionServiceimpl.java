package com.example.spring_exception_validation.service;

import com.example.spring_exception_validation.Exception.PersonNotFound;
import com.example.spring_exception_validation.entity.Person;
import com.example.spring_exception_validation.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersionServiceimpl implements PersonService{
    private PersonRepo personRepo;
    @Autowired
    public PersionServiceimpl(PersonRepo personRepo)
    {
        this.personRepo=personRepo;
    }
    @Override
    public List<Person> listall() {
        return personRepo.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }



    @Override
    public void deletebyid(long id) {
        if(personRepo.existsById(id))
        {
            personRepo.deleteById(id);
        }
        else {
            throw new PersonNotFound("NOT FOUND");
        }
    }

    @Override
    public Person findbyid(long id) {
        return personRepo.findById(id).orElseThrow(()->new PersonNotFound("Not found"));
    }
}
