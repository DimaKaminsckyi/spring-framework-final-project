package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.Starship;
import com.basecamp.springframeworkfinalproject.domain.SwapiPerson;

import java.util.List;

public interface SwapiService {

    Person getFromAPI(String personName);

    List<Starship> getStarshipFromAPI(SwapiPerson swapiPerson);
}
