package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    Person saveVehicleResult(String personName , String state);

    Person saveStarshipResult(String personName , String state);

    List<Person> findAll();

    Person findByUUId(UUID uuid);


}
