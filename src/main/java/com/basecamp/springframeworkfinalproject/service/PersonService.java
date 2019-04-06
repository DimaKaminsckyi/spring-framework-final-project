package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    Person saveMachineResult(String kindOfMachine , String state , String personName);

    String calculateResponse(UUID uuid);

    List<Person> findAllPagination(int page , int size);

    List<Person> getAllUuidByStateResult(String state);

}
