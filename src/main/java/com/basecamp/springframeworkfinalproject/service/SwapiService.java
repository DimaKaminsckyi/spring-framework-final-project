package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.Starship;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiPerson;
import com.basecamp.springframeworkfinalproject.domain.Vehicle;

import java.util.List;

public interface SwapiService {

    Person getPersonFromAPI(String personName);

    List<Starship> getStarshipFromAPI(SwapiPerson swapiPerson);

    List<Vehicle> getVehicleFromAPI(SwapiPerson swapiPerson);
}
