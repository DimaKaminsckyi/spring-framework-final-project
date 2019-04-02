package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.wire.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final PersonService personService;

    @PostMapping("/vehicle/{state}/{personName}")
    public ResponseEntity<?> saveFastestVehiclelResult( @PathVariable String state , @PathVariable String personName){

        Person person = personService.saveVehicleResult(personName , state);
        SaveResponse response = new SaveResponse();
        response.setId(person.getUuid());
        response.setResponse("GET this uuid to see result !");

        return new ResponseEntity(response , HttpStatus.CREATED);
    }
}
