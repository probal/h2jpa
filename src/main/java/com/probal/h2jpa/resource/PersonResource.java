package com.probal.h2jpa.resource;

import com.probal.h2jpa.model.Person;
import com.probal.h2jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by probal on 14/2/19.
 */
@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person) {
        System.out.println("In save");
        return personRepository.save(person);
    }

    @GetMapping(value = "/all")
    public List<Person> getAllPerson() {
        System.out.println("Getting all person...");
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @GetMapping(value = "/name/{name}")
    public List<Person> getPersonByName(@PathVariable String name) {
        List<Person> persons = new ArrayList<>();
        personRepository.findByName(name).forEach(persons::add);
        return persons;
    }

}
