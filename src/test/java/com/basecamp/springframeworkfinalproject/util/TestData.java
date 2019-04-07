package com.basecamp.springframeworkfinalproject.util;

import com.basecamp.springframeworkfinalproject.domain.Machine;
import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiPerson;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiSearch;
import com.basecamp.springframeworkfinalproject.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static Person generatePerson(){
        Person person = new Person();
        person.setName("Luke Skywalker");
        person.setPersonId(22);

        return person;
    }

    public static List<Machine> generateMachine(){
        List<Machine> machines = new ArrayList<>();
        Machine machine = new Machine();
        machine.setCost("149999");
        machine.setName("X-wing");
        machine.setKindOfMachine("starship");
        machine.setSpeed(1050);
        machines.add(machine);

        return machines;
    }

    public static List<Machine> generateStarships(){
        List<Machine> machines = new ArrayList<>();
        Machine machine = new Machine();
        machine.setKindOfMachine("starship");
        machine.setMachineId(3);
        machine.setCost("149999");
        machine.setName("X-wing");
        machine.setSpeed(1050);

        Machine machine1 = new Machine();
        machine1.setKindOfMachine("starship");
        machine1.setCost("24000");
        machine1.setName("Imperial Shuttle");
        machine1.setSpeed(850);

        machines.add(machine);
        machines.add(machine1);
        return machines;
    }

    public static List<Machine> generateVehicles(){
        List<Machine> machines = new ArrayList<>();
        Machine machine = new Machine();
        machine.setKindOfMachine("vehicle");
        machine.setCost("0");
        machine.setName("Snowspeeder");
        machine.setSpeed(650);

        Machine machine1 = new Machine();
        machine1.setSpeed(700);
        machine1.setKindOfMachine("vehicle");
        machine1.setName("Imperial Speeder Bike");
        machine1.setCost("8000");

        machines.add(machine);
        machines.add(machine1);
        return machines;
    }

    public static SwapiSearch generateSwapiSearch(){
        String[] starships = new String[1];
        starships[0] = "https://swapi.co/api/starships/22/";
        SwapiSearch swapiSearch = new SwapiSearch();
        SwapiPerson swapiPerson = new SwapiPerson();
        swapiPerson.setUrl("https://swapi.co/api/starships/22/");
        swapiPerson.setKindOfMachine("starship");
        swapiPerson.setName("Luke Skywalker");
        swapiPerson.setStarships(starships);
        swapiSearch.setCount(1);
        SwapiPerson[] swapiPersons = new SwapiPerson[1];
        swapiPersons[0] = swapiPerson;
        swapiSearch.setResults(swapiPersons);
        return swapiSearch;
    }

    public static Person saveToDB(PersonRepository personRepository){
        Person person = generatePerson();
        person.setState("fastest");
        Machine starship = generateStarships().get(0);
        List<Machine> machines = new ArrayList<>();
        machines.add(starship);
        person.setMachines(machines);

        personRepository.save(person);

        return person;
    }
}
