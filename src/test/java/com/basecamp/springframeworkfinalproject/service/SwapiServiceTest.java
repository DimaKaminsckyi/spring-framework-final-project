package com.basecamp.springframeworkfinalproject.service;

import com.basecamp.springframeworkfinalproject.domain.Machine;
import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.api.SwapiSearch;
import com.basecamp.springframeworkfinalproject.service.impl.SwapiServiceImpl;
import com.basecamp.springframeworkfinalproject.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class SwapiServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SwapiServiceImpl swapiService;

    @Test
    public void whenGetPersonFromAPI_thanReturnCorrectPerson(){
        SwapiSearch swapiSearch = TestData.generateSwapiSearch();
        List<Machine> machines = TestData.generateMachine();

        when(restTemplate.getForObject("https://swapi.co/api/people/?search=Luke Skywalker", SwapiSearch.class))
                .thenReturn(swapiSearch);
        when(restTemplate.getForObject("https://swapi.co/api/starships/22/" , Machine.class)).thenReturn(machines.get(0));
        Person person = TestData.generatePerson();
        person.setMachines(machines);

        assertEquals(person , swapiService.getPersonFromAPI("Luke Skywalker" , "starship"));
    }

}
