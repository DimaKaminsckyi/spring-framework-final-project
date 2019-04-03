package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.Starship;
import com.basecamp.springframeworkfinalproject.domain.Vehicle;
import com.basecamp.springframeworkfinalproject.exception.InvalidStateException;
import com.basecamp.springframeworkfinalproject.repository.PersonRepository;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.service.StarshipService;
import com.basecamp.springframeworkfinalproject.service.SwapiService;
import com.basecamp.springframeworkfinalproject.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final StarshipService starshipService;
    private final SwapiService swapiService;
    private final VehicleService vehicleService;


    @Override
    public Person saveVehicleResult(String personName, String state) {
        Vehicle vehicle;
        Person person = swapiService.getPersonFromAPI(personName);

        switch (state){
            case "expensive":
                vehicle = vehicleService.countMostExpensiveVehicle(person.getVehicles());
                break;
            case "fastest":
                vehicle = vehicleService.countFastestVehicle(person.getVehicles());
                break;
            default:
                throw new InvalidStateException("please enter correct state : " +
                        " http://localhost:8080/vehicle/{fastest/expensive}/" + personName);

        }
        person.clearLists();
        person.addVehicle(vehicle);
        personRepository.save(person);

        return person;
    }

    @Override
    public Person saveStarshipResult(String personName, String state) {
        Starship starship;
        Person person = swapiService.getPersonFromAPI(personName);

        switch (state){
            case "expensive":
                starship = starshipService.countMostExpensiveStarship(person.getStarships());
                break;
            case "fastest":
                starship = starshipService.countFastestStarship(person.getStarships());
                break;
            default:
                throw new InvalidStateException("please enter correct state : " +
                        " http://localhost:8080/starship/{fastest/expensive}/" + personName);

        }
        person.clearLists();
        person.addStarship(starship);
        personRepository.save(person);

        return person;
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }


    @Override
    public Person findByUUId(UUID uuid) {
        return personRepository.findById(uuid).get();
    }

}
