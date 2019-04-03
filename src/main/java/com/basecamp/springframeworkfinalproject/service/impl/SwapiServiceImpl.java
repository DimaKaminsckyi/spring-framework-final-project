package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.*;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiPerson;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiSearch;
import com.basecamp.springframeworkfinalproject.exception.PersonNotFoundException;
import com.basecamp.springframeworkfinalproject.service.SwapiService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SwapiServiceImpl implements SwapiService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final RestTemplate restTemplate;

    @Override
    public Person getPersonFromAPI(String personName) {
        String swapiPersonURL = "https://swapi.co/api/people/?search=" + personName;
        Person person = new Person();

        SwapiSearch swapiSearch = restTemplate.getForObject(
                swapiPersonURL, SwapiSearch.class);

        log.info("Result count " + swapiSearch.getCount());

        for (SwapiPerson p : swapiSearch.getResults()){
            if (p.getName().equals(personName)){
                person.setName(p.getName());
                person.setPersonId(Integer.valueOf(p.getUrl().
                        replaceAll("\\D+","")));
                person.setStarships(getStarshipFromAPI(p));
                person.setVehicles(getVehicleFromAPI(p));
                return person;
            }
        }

        throw new PersonNotFoundException("please enter correct person name");
    }

    @Override
    public List<Starship> getStarshipFromAPI(SwapiPerson swapiPerson) {
        List<Starship> starships = new ArrayList<>();
        Starship starship;
        for (String s : swapiPerson.getStarships()){

            starship = restTemplate.getForObject(s , Starship.class);
            starship.setStarshipId(Integer.valueOf(s.
                    replaceAll("\\D+","")));

            if (starship.getCost().equals("unknown")){
                starship.setCost("0");
            }

            starships.add(starship);
        }

        return starships;
    }

    @Override
    public List<Vehicle> getVehicleFromAPI(SwapiPerson swapiPerson) {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle;
        for (String s : swapiPerson.getVehicles()){

            vehicle = restTemplate.getForObject(s , Vehicle.class);
            vehicle.setVechicleId(Integer.valueOf(s.
                    replaceAll("\\D+","")));

            if (vehicle.getCost().equals("unknown")){
                vehicle.setCost("0");
            }

            vehicles.add(vehicle);
        }
        return vehicles;
    }


}
