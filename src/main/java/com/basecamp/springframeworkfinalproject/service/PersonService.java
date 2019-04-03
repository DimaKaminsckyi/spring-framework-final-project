package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    Person saveMachineResult(String kindOfMachine , String state , String personName);

    List<Person> findAll();

    Person findByUUId(UUID uuid);


}
