package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.domain.Starship;
import com.basecamp.springframeworkfinalproject.exception.PersonNotFoundException;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.service.StarshipService;
import com.basecamp.springframeworkfinalproject.wire.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StarshipController {

    private final PersonService personService;
    private final StarshipService starshipService;

    @PostMapping("/starship/{state}/{personName}")
    public ResponseEntity<?> saveFastestStarshiplResult(@PathVariable String state , @PathVariable String personName){

        Person person = personService.saveStarshipResult(personName , state);

        SaveResponse response = new SaveResponse();
        response.setId(person.getUuid());
        response.setResponse("GET this uuid to see result !");

        return new ResponseEntity(response , HttpStatus.CREATED);
    }

    @GetMapping("/starships")
    public ResponseEntity<List<Starship>> getStarsips(){
        return new ResponseEntity<>(starshipService.findAll() , HttpStatus.OK);
    }

    @GetMapping("/starship/{starshipId}")
    public ResponseEntity<Starship> getStarsip(@PathVariable int starshipId){
        return new ResponseEntity<>(starshipService.findById(starshipId) , HttpStatus.OK);
    }

}
