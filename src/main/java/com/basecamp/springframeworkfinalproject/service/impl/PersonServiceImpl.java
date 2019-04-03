package com.basecamp.springframeworkfinalproject.service.impl;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.Machine;
import com.basecamp.springframeworkfinalproject.exception.InvalidStateException;
import com.basecamp.springframeworkfinalproject.repository.PersonRepository;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.service.MachineService;
import com.basecamp.springframeworkfinalproject.service.SwapiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final MachineService machineService;
    private final SwapiService swapiService;


    @Override
    public Person saveMachineResult(String kindOfMachine ,  String state , String personName) {
        Machine machine;
        Person person = swapiService.getPersonFromAPI(personName , kindOfMachine);

        switch (state){
            case "expensive":
                machine = machineService.countMostExpensiveMachine(person.getMachines());
                break;
            case "fastest":
                machine = machineService.countFastestMachine(person.getMachines());
                break;
            default:
                throw new InvalidStateException("please enter correct state : " +
                        " http://localhost:8080/"+ state +"/{fastest/expensive}/" + personName);

        }

        person.addMachine(machine);
        person.setResponse(state);

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
