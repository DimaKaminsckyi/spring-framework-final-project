package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Machine;
import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.repository.PersonRepository;
import com.basecamp.springframeworkfinalproject.service.impl.MachineServiceImpl;
import com.basecamp.springframeworkfinalproject.service.impl.PersonServiceImpl;
import com.basecamp.springframeworkfinalproject.service.impl.SwapiServiceImpl;
import com.basecamp.springframeworkfinalproject.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private SwapiServiceImpl swapiService;

    @Mock
    private MachineServiceImpl machineService;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void whenSaveMachineResult_returnCorrectPerson(){
        //prepare
        Person person = TestData.generatePerson();
        List<Machine> machines = TestData.generateStarships();
        person.setMachines(machines);
        person.setState("fastest");
        when(swapiService.getPersonFromAPI("Luke Skywalker" , "starship")).thenReturn(person);
        when(machineService.countFastestMachine(person.getMachines())).thenReturn(machines.get(0));
        person.addMachine(machines.get(0));

        assertEquals(person , personService.saveMachineResult(
                "starship" , "fastest" , "Luke Skywalker"));
    }


    @Test
    public void whenCalculateRepsonse_thanReturnCorrectString(){
        //prepare
        UUID uuid = UUID.randomUUID();
        Person person = TestData.generatePerson();
        person.setMachines(TestData.generateStarships());
        Machine machine = person.getMachines().get(0);
        person.setState("fastest");

        String expected = person.getName() + '(' + person.getPersonId() + ')' + " was driving " +
                '(' + machine.getKindOfMachine() + ')' +machine.getName() + '(' + machine.getMachineId() + ')' + " with speed " +
                machine.getSpeed();

        when(personRepository.findById(uuid)).thenReturn(java.util.Optional.ofNullable(person));
        String actual = personService.calculateResponse(uuid);

        assertEquals(expected , actual);
    }

    @Test
    public void whenGetAllUUidByState_ReturnCorrectUUid(){
        //prepare
        UUID uuid = UUID.randomUUID();
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setUuid(uuid);
        person.setName("Luke Skywalker");
        personList.add(person);
        when(personRepository.getAllUuidByStateResult("starship")).thenReturn(personList);

        assertEquals(personList , personService.getAllUuidByStateResult("starship"));


    }
}