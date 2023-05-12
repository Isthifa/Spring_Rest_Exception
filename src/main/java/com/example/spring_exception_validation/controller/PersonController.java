package com.example.spring_exception_validation.controller;

import com.example.spring_exception_validation.entity.Person;
import com.example.spring_exception_validation.service.PersonService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/person")
public class PersonController {
    Logger logger= LoggerFactory.getLogger(PersonController.class);
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService=personService;
    }
    @PostMapping("/save")
    @Operation(summary = "Save data",description = "Save Operation")
    public Person save(@Valid @RequestBody Person person)
    {
        Person person1=personService.save(person);
        logger.info("Saving the data");
        return person;
    }
    @GetMapping("/list")
    @Operation(summary = "list all data")
    public List<Person> list()
    {
        List<Person> personList=personService.listall();
        //logger.trace("list method accessed");
        logger.info("return list of personlist");
        return personList;
    }
    @GetMapping("/{id}")
    @Operation(summary = "find by id")
    public Person getbyid(@Valid @PathVariable long id)
    {
        Person person=personService.findbyid(id);
        logger.info("find by id");
        return person;
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete by id", description = "id should not be null")
    public String Delete(@PathVariable long id)
    {
        Person person=personService.findbyid(id);
        if(person!=null) {
            logger.info("deleting the data");
            personService.deletebyid(id);
        }
        return "Deleted "+id;
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update the existing data",description ="value min 2 character, should not be null" )
    public Person update(@Valid @PathVariable long id,@RequestBody Person person)
    {
        Person person1=personService.findbyid(id);
        person1.setId(person.getId());
        person1.setFirstname(person.getFirstname());
        person1.setLastname(person.getLastname());
        person1.setEmail(person.getEmail());
        logger.info("updating");
        personService.save(person1);

        return person1;
    }
}
