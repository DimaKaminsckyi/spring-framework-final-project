package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SwapiController {

    private final PersonService personService;


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons(){
        return new ResponseEntity<>(personService.findAll() , HttpStatus.OK);
    }



}
