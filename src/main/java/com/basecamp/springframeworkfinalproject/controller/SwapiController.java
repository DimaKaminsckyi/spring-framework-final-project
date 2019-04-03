package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SwapiController {

    private final PersonService personService;

    @GetMapping("/{uuid}")
    public ResponseEntity<Person> getPerson(@PathVariable UUID uuid){
        Person person = personService.findByUUId(uuid);
        return new ResponseEntity<>(personService.findByUUId(uuid) , HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons(){
        return new ResponseEntity<>(personService.findAll() , HttpStatus.OK);
    }



}
