package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.Starship;
import com.basecamp.springframeworkfinalproject.domain.SwapiPerson;
import com.basecamp.springframeworkfinalproject.domain.SwapiSearch;
import com.basecamp.springframeworkfinalproject.service.SwapiService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SwapiServiceImpl implements SwapiService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final RestTemplate restTemplate;


    @Override
    public Person getFromAPI(String personName) {
        String swapiPersonURL = "https://swapi.co/api/people/?search=" + personName;
        List<Starship> starships;
        Person person = new Person();

        SwapiSearch swapiSearch = restTemplate.getForObject(
                swapiPersonURL, SwapiSearch.class);

        log.info("Result count " + swapiSearch.getCount());

        for (SwapiPerson p : swapiSearch.getResults()){
            if (p.getName().equals(personName)){
                starships = getStarshipFromAPI(p);
                person.setStarships(starships);
                person.setName(p.getName());
                log.info(String.valueOf(person));
                return person;
            }
        }

        throw new NoSuchElementException("error");
    }

    @Override
    public List<Starship> getStarshipFromAPI(SwapiPerson swapiPerson) {
        List<Starship> starships = new ArrayList<>();
        for (String s : swapiPerson.getStarships()){
            starships.add(restTemplate.getForObject(s , Starship.class));

        }
        log.info("Starships of Person : " + starships);
        return starships;
    }


}
