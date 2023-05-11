package com.example.spring_exception_validation.controller;

import com.example.spring_exception_validation.entity.Person;
import com.example.spring_exception_validation.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService=personService;
    }
    @PostMapping("/save")
    public Person save(@Valid @RequestBody Person person)
    {
        Person person1=personService.save(person);
        return person;
    }
    @GetMapping("/list")
    public List<Person> list()
    {
        List<Person> personList=personService.listall();
        return personList;
    }
    @GetMapping("/{id}")
    public Person getbyid(@Valid @PathVariable long id)
    {
        Person person=personService.findbyid(id);
        return person;
    }
    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable long id)
    {
        Person person=personService.findbyid(id);
        if(person!=null) {
            personService.deletebyid(id);
        }
        return "Deleted "+id;
    }

    @PutMapping("/update/{id}")
    public Person update(@Valid @PathVariable long id,@RequestBody Person person)
    {
        Person person1=personService.findbyid(id);
        person1.setId(person.getId());
        person1.setFirstname(person.getFirstname());
        person1.setLastname(person.getLastname());
        person1.setEmail(person.getEmail());
        personService.save(person1);

        return person1;
    }
}
