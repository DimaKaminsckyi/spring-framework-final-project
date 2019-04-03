package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Person;

public interface SwapiService {

    Person getPersonFromAPI(String personName , String kindOfMachine);

}
