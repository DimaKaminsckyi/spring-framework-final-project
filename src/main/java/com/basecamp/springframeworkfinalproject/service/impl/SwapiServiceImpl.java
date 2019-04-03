package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.*;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiPerson;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiSearch;
import com.basecamp.springframeworkfinalproject.exception.InvalidMachineRequestException;
import com.basecamp.springframeworkfinalproject.exception.PersonDoesNotHaveStarshipOrVehicleException;
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
    public Person getPersonFromAPI(String personName , String kindOfMachine) {
        String swapiPersonURL = "https://swapi.co/api/people/?search=" + personName;
        Person person = new Person();

        SwapiSearch swapiSearch = restTemplate.getForObject(
                swapiPersonURL, SwapiSearch.class);

        log.info("Result count " + swapiSearch.getCount());

        for (SwapiPerson p : swapiSearch.getResults()){
            if (p.getName().equals(personName)){

                p.setKindOfMachine(kindOfMachine);

                person.setName(p.getName());
                person.setPersonId(Integer.valueOf(p.getUrl().
                        replaceAll("\\D+","")));
                person.setMachines(getMachineFromAPI(p));
                return person;
            }
        }

        throw new PersonNotFoundException("please enter correct person name");
    }

    private List<Machine> getMachineFromAPI(SwapiPerson swapiPerson) {
        List<Machine> machines = new ArrayList<>();
        Machine machine;
        for (String s : checkMachineFromAPI(swapiPerson)){

            machine = restTemplate.getForObject(s , Machine.class);
            machine.setKindOfMachine(swapiPerson.getKindOfMachine());
            machine.setMachineId(Integer.valueOf(s.
                    replaceAll("\\D+","")));

            if (machine.getCost().equals("unknown")){
                machine.setCost("0");
            }

            machines.add(machine);
        }
        return machines;
    }

    private String[] checkMachineFromAPI(SwapiPerson swapiPerson){
        String[] array;
        switch (swapiPerson.getKindOfMachine()){
            case "starship":
                array = swapiPerson.getStarships();
                break;
            case "vehicle":
                array = swapiPerson.getVehicles();
                break;
            default:
                throw new InvalidMachineRequestException("please enter starship or vehicle for request");
        }
        if (array.length == 0){throw new PersonDoesNotHaveStarshipOrVehicleException(
                "person does not have starship or vehicle");}
        return array;
    }

}
